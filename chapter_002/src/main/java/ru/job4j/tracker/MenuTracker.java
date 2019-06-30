package ru.job4j.tracker;


public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new ExitProgram();
    }

    public void select(int key) {
        this.actions[key].execute(input, tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            long currentTime = System.currentTimeMillis();
            Item item = new Item(name, desc, currentTime);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    private class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки --------------");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.print("Name : " + item.getName());
                System.out.print("    Description : " + item.getDecs());
                System.out.println("    Create Time : " + item.getTime());
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all Items");
        }
    }

    private class EditItem implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id редактируемой заявки : ");
            String name = input.ask("Введите новое имя:");
            String desc = input.ask("Введите новое описание :");
            long currentTime = System.currentTimeMillis();
            Item item = new Item(name, desc, currentTime);
            boolean result = tracker.replace(id, item);
            if (result) {
                System.out.println(String.format("------------ Заявка с id %s редактирована -----------", id));
            } else {
                System.out.println("Не удалось редактировать заявку. Проверьте id.");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Edit Item");
        }
    }

    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки : ");
            boolean result = tracker.delete(id);
            if (result) {
                System.out.println(String.format("------------ Заявка с id %s удалена -----------", id));
            } else {
                System.out.println("Не удалось удалить заявку. Проверьте id.");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete Item");
        }
    }

    private class FindById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки : ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.print("Name : " + item.getName());
                System.out.print("    Description : " + item.getDecs());
                System.out.println("    Create Time : " + item.getTime());

            } else {
                System.out.println("Заявка не найдена. Проверьте id.");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find Item by id");
        }
    }

    private class FindByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени --------------");
            String key = input.ask("Введите имя заявки : ");
            Item[] items = tracker.findByName(key);
            for (Item item : items) {
                System.out.print("Name : " + item.getName());
                System.out.print("    Description : " + item.getDecs());
                System.out.println("    Create Time : " + item.getTime());
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find Items by name");
        }
    }

    private class ExitProgram implements UserAction {
        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("До встречи!");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }
}
