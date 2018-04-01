package ru.job4j.testTask;

public class FirstThread extends Thread {
    private final StringContainer container;

    public FirstThread(StringContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        synchronized (container) {
            for (int i = 0; i < 30; i++) {
                while (container.isFlag()) {
                    try {
                        System.out.println("First is waiting");
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                container.addNumber(1);
                container.incrementCapacity();
                System.out.println("m");

                container.notifyAll();
            }
        }
    }
}

