package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.function.Consumer;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private Consumer<String> output;
    private ArrayList<UserAction> actions = new ArrayList<>();

    public int getActionsLength() {
        return this.actions.size();
    }

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all Items"));
        this.actions.add(new EditItem(2, "Edit Item"));
        this.actions.add(new DeleteItem(3, "Delete Item"));
        this.actions.add(new FindById(4, "Find Item by id"));
        this.actions.add(new FindByName(5, "Find Items by name"));
        this.actions.add(new ExitProgram(ui, 6, "Exit Program"));
    }

    public void select(int key) {
        this.actions.get(key).execute(input, tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            long currentTime = System.currentTimeMillis();
            Item item = new Item(name, desc, currentTime);
            tracker.add(item);
            output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");

        }
    }

    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Все заявки --------------");
            ArrayList<Item> items = tracker.findAll();
            for (Item item : items) {
                output.accept(String.format("Name : %s    Description : %s    Create Time : %s",
                        item.getName(), item.getDecs(), item.getTime()));

            }
        }
    }

    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id редактируемой заявки : ");
            String name = input.ask("Введите новое имя:");
            String desc = input.ask("Введите новое описание :");
            long currentTime = System.currentTimeMillis();
            Item item = new Item(name, desc, currentTime);
            boolean result = tracker.replace(id, item);
            if (result) {
                output.accept(String.format("------------ Заявка с id %s редактирована -----------", id));
            } else {
                output.accept("Не удалось редактировать заявку. Проверьте id.");
            }
        }
    }

    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки : ");
            boolean result = tracker.delete(id);
            if (result) {
                output.accept(String.format("------------ Заявка с id %s удалена -----------", id));
            } else {
                output.accept("Не удалось удалить заявку. Проверьте id.");
            }
        }
    }

    private class FindById extends BaseAction {
        public FindById(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки : ");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(String.format("Name : %s    Description : %s    Create Time : %s",
                        item.getName(), item.getDecs(), item.getTime()));

            } else {
                output.accept("Заявка не найдена. Проверьте id.");
            }
        }
    }

    private class FindByName extends BaseAction {
        public FindByName(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени --------------");
            String key = input.ask("Введите имя заявки : ");
            ArrayList<Item> items = tracker.findByName(key);
            for (Item item : items) {
                System.out.print("Name : " + item.getName());
                System.out.print("    Description : " + item.getDecs());
                System.out.println("    Create Time : " + item.getTime());
            }
        }
    }

    private class ExitProgram extends BaseAction {
        private StartUI ui;

        public ExitProgram(StartUI ui, int key, String name) {
            super(key, name);
            this.ui = ui;
        }
        public ExitProgram(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("До встречи!");
            ui.stop();
        }
    }
}
