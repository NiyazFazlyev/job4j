package ru.job4j.tracker;


import java.util.function.Consumer;

/**
 * @author Niyaz Fazlyev
 * @version 1.0
 * @since 25.06.2019
 */

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    private boolean working = true;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Запускт программы.
     *
     * @param args Входные параметры
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(input, tracker, output);
        menu.fillActions(this);
        int actions = menu.getActionsLength();
        int[] range = new int[actions];
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
        } while (working);

    }

    public void stop() {
        working = false;
    }

}