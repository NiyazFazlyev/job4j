package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenAdd3Items() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription", 124L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription", 125L);
        tracker.add(item3);
        Item[] result = {item1, item2, item3};
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void when3ItemsHaveSameName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription", 124L);
        tracker.add(item2);
        Item item3 = new Item("test1", "testDescription", 125L);
        tracker.add(item3);
        Item item4 = new Item("test1", "testDescription", 123L);
        tracker.add(item4);
        Item item5 = new Item("test2", "testDescription", 123L);
        tracker.add(item5);
        Item[] result = {item1, item3, item4};
        assertThat(tracker.findByName("test1"), is(result));
    }


    @Test
    public void whenDelete2Items() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription", 124L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription", 125L);
        tracker.add(item3);
        Item item4 = new Item("test4", "testDescription", 123L);
        tracker.add(item4);
        Item item5 = new Item("test5", "testDescription", 123L);
        tracker.add(item5);
        tracker.delete(item1.getId());
        tracker.delete(item4.getId());
        Item[] result = {item2, item3, item5};
        assertThat(tracker.findAll(), is(result));
    }
}