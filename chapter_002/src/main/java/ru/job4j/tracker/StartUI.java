package ru.job4j.tracker;

/**
 * @author Niyaz Fazlyev
 * @version 1.0
 * @since 25.06.2019
 */
public class StartUI {
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
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(input, tracker);
        int actions = menu.getActionsLenght();
        int[] range = new int[actions];
        menu.fillActions();
        for (int i = 0; i != actions; i++) {
            range[i] = i;
        }
        int key;
        boolean exit = false;
        do {
            menu.show();
            key = input.ask("Select: ", range);
            menu.select(key);
            if (key == 6) {
                break;
            }
        } while (true);

    }

}