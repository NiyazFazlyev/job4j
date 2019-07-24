package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // получаем ссылку на стандартный вывод в консоль.
    PrintStream stdout = System.out;
    // Создаем буфур для хранения вывода.
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    StringBuilder menu = new StringBuilder()
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all Items")
            .append(System.lineSeparator())
            .append("2. Edit Item")
            .append(System.lineSeparator())
            .append("3. Delete Item")
            .append(System.lineSeparator())
            .append("4. Find Item by id")
            .append(System.lineSeparator())
            .append("5. Find Items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator());

    @Before
    public void loadOutput() {
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 123424422));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNotItem() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 123424422));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        tracker.delete(item.getId());
        // проверяем, что заявки с таким id нет.
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindAll() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявки
        Item item1 = tracker.add(new Item("test name1", "desc1", 123424422));
        Item item2 = tracker.add(new Item("test name2", "desc2", 123424455));
        //создаём StubInput с последовательностью действий(вывод всех заявок)
        Input input = new StubInput(new String[]{"1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder(menu)
                                .append("------------ Все заявки --------------")
                                .append(System.lineSeparator())
                                .append("Name : " + item1.getName())
                                .append("    Description : " + item1.getDecs())
                                .append("    Create Time : " + item1.getTime())
                                .append(System.lineSeparator())
                                .append("Name : " + item2.getName())
                                .append("    Description : " + item2.getDecs())
                                .append("    Create Time : " + item2.getTime())
                                .append(System.lineSeparator())
                                .append(menu)
                                .append("До встречи!")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявки
        Item item1 = tracker.add(new Item("test name1", "desc1", 123424422));
        Item item2 = tracker.add(new Item("test name2", "desc2", 123424455));
        Item item3 = tracker.add(new Item("test name1", "desc3", 123424488));
        //создаём StubInput с последовательностью действий(вывод всех заявок с именем test1)
        Input input = new StubInput(new String[]{"5", "test name1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder(menu)
                                .append("------------ Поиск заявок по имени --------------")
                                .append(System.lineSeparator())
                                .append("Name : " + item1.getName())
                                .append("    Description : " + item1.getDecs())
                                .append("    Create Time : " + item1.getTime())
                                .append(System.lineSeparator())
                                .append("Name : " + item3.getName())
                                .append("    Description : " + item3.getDecs())
                                .append("    Create Time : " + item3.getTime())
                                .append(System.lineSeparator())
                                .append(menu)
                                .append("До встречи!")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
