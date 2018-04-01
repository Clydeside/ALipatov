package ru.job4j.testTask;

public class SecondThread extends Thread {
    private final StringContainer container;

    public SecondThread(StringContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        synchronized (container) {
            for (int i = 0; i < 30; i++) {
                while (!container.isFlag()) {
                    try {
                        System.out.println("Second is waiting");
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                container.addNumber(2);
                container.incrementCapacity();
                System.out.println("t");

                container.notifyAll();
            }
        }
    }
}

