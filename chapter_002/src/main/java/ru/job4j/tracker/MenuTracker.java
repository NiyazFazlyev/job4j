package ru.job4j.tracker;


public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public int getActionsLenght() {
        return actions.length;
    }

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem(0, "Add new Item");
        this.actions[1] = new ShowItems(1, "Show all Items");
        this.actions[2] = new EditItem(2, "Edit Item");
        this.actions[3] = new DeleteItem(3, "Delete Item");
        this.actions[4] = new FindById(4, "Find Item by id");
        this.actions[5] = new FindByName(5, "Find Items by name");
        this.actions[6] = new ExitProgram(6, "Exit Program");
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

    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
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
    }

    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
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
    }

    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
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
    }

    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
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
    }

    private class FindById extends BaseAction {
        public FindById(int key, String name) {
            super(key, name);
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
    }

    private class FindByName extends BaseAction {
        public FindByName(int key, String name) {
            super(key, name);
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
    }

    private class ExitProgram extends BaseAction {
        public ExitProgram(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("До встречи!");
        }
    }
}
