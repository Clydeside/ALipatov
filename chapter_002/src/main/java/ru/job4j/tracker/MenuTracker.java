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
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemByID();
        this.actions[5] = new FindItemByName();
        this.actions[6] = new Exit();
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

    private void showItem(Item item) {
        System.out.print(" Name: " + item.getName());
        System.out.print(" Description: " + item.getDesc());
        System.out.println(" Id: " + item.getId());
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's description: ");
            tracker.add(new Item(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new item.");
        }
    }

    private class FindItemByID implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID заявки :");
            Item item = tracker.findById(id);
            showItem(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id.");
        }
    }

    private class FindItemByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите NAME заявки :");
            Item[] item = tracker.findByName(name);
            for (int i = 0; i < item.length; i++) {
                if (item[i] != null)
                    showItem(item[i]);
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name.");
        }
    }

    private class Exit implements UserAction {
        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            System.exit(0);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit.");
        }
    }

    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID заявки :");
            Item item = tracker.findById(id);
            tracker.delete(item);
            System.out.println("Deleted!");
        }


        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                if (item != null) {
                    System.out.println(String.format("%s | %s | %s", item.getName(), item.getDesc(), item.getId()));
                }
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }
}

class EditItem implements UserAction {
    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id: ");
        String name = input.ask("Please, enter the task's name: ");
        String desc = input.ask("Please, enter the task's description: ");
        Item item = tracker.findById(id);
        item.setName(name);
        item.setDesc(desc);
        tracker.update(item);
        System.out.println("Updated!");
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit item.");
    }
}
