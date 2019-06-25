package ru.job4j.tracker;

/**
 * @author Niyaz Fazlyev
 * @version 1.0
 * @since 25.06.2019
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String ID = "4";

    /**
     * Константа меню для поиска заявок по имени.
     */
    private static final String NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Запускт программы.
     *
     * @param args Входные параметры
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case ID:
                    this.findItemById();
                    break;
                case NAME:
                    this.findItemsByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * Метод реализует вывод меню для пользователя.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all Items");
        System.out.println("2. Edit Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Find Item by id");
        System.out.println("5. Find Items by name");
        System.out.println("6. Exit program");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long currentTime = System.currentTimeMillis();
        Item item = new Item(name, desc, currentTime);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод всех заявок.
     */
    private void showItems() {
        System.out.println("------------ Все заявки --------------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.print("Name : " + item.getName());
            System.out.print("    Description : " + item.getDecs());
            System.out.println("    Create Time : " + item.getTime());
        }
    }

    /**
     * Метод реализует редактирование существующей заявки.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id редактируемой заявки : ");
        String name = this.input.ask("Введите новое имя:");
        String desc = this.input.ask("Введите новое описание :");
        long currentTime = System.currentTimeMillis();
        Item item = new Item(name, desc, currentTime);
        boolean result = this.tracker.replace(id, item);
        if (result) {
            System.out.println(String.format("------------ Заявка с id %s редактирована -----------", id));
        } else {
            System.out.println("Не удалось редактировать заявку. Проверьте id.");
        }
    }

    /**
     * Метод реализует удаление удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки : ");
        boolean result = this.tracker.delete(id);
        if (result) {
            System.out.println(String.format("------------ Заявка с id %s удалена -----------", id));
        } else {
            System.out.println("Не удалось удалить заявку. Проверьте id.");
        }
    }

    /**
     * Метод реализует поиск заявки по id.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.print("Name : " + item.getName());
            System.out.print("    Description : " + item.getDecs());
            System.out.println("    Create Time : " + item.getTime());

        } else {
            System.out.println("Заявка не найдена. Проверьте id.");
        }
    }

    /**
     * Метод реализует поиск заявок по имени.
     */
    private void findItemsByName() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String key = this.input.ask("Введите имя заявки : ");
        Item[] items = this.tracker.findByName(key);
        for (Item item : items) {
            System.out.print("Name : " + item.getName());
            System.out.print("    Description : " + item.getDecs());
            System.out.println("    Create Time : " + item.getTime());
        }
    }
}