package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
//        MenuTracker menu = new MenuTracker(input, tracker);
//        menu.fillActions();
//        do {
//            menu.show();
//            int key = Integer.valueOf(input.ask("Select: "));
//            menu.select(key);
//        }
//        while (!"y".equals(this.input.ask("Exit?(y): ")));

        Tracker tracker = new Tracker();
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            }
            else if (SHOW.equals(answer)) {
                showAllItems();
            }
            else if (EDIT.equals(answer)) {
                editItem();
            }
            else if (DELETE.equals(answer)) {
                deleteItem();
            }
            else if (FIND_BY_ID.equals(answer)) {
                findItemById();
            }
            else if (FIND_BY_NAME.equals(answer)) {
                findItemByName();
            }
            else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void findItemByName() {
        String name = this.input.ask("Введите NAME заявки :");
        Item[] item = tracker.findByName(name);
        for (int i = 0; i < item.length; i++) {
            if (item[i] != null)
                showItem(item[i]);
        }
    }

    private void findItemById() {
        String id = this.input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        this.showItem(item);
    }

    private void deleteItem() {
        String id = this.input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        tracker.delete(item);
        System.out.println("Deleted!");
    }

    private void showAllItems() {
        Item[] result = this.tracker.findAll();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                System.out.print(i + ")");
                showItem(result[i]);
            }
        }
    }

    private void editItem() {
        String id = this.input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        item.setName(name);
        item.setDesc(desc);
        tracker.update(item);
        System.out.println("Updated!");
    }

    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showItem(Item item) {
        System.out.print(" Name: " + item.getName());
        System.out.print(" Description: " + item.getDesc());
        System.out.println(" Id: " + item.getId());
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 - ADD");
        System.out.println("1 - SHOW");
        System.out.println("2 - EDIT");
        System.out.println("3 - DELETE");
        System.out.println("4 - FIND_BY_ID");
        System.out.println("5 - FIND_BY_NAME");
        System.out.println("6 - EXIT");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
