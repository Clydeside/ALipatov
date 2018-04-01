package ru.job4j.testTask;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class StringContainer {
    @GuardedBy("this")
    private String str = "";
    @GuardedBy("this")
    private boolean flag = false;
    @GuardedBy("this")
    private int capacity = 0;

    public synchronized boolean isFlag() {
        return flag;
    }

    public synchronized void changeState() {
        if (flag) {
            flag = false;
        } else {
            flag = true;
        }
    }

    public synchronized void incrementCapacity() {
        capacity++;
        if (capacity == 10) {
            capacity = 0;
            changeState();
        }
    }

    public synchronized String getStr() {
        return str;
    }

    public synchronized void addNumber(int number) {
        str = str.concat(Integer.toString(number));
    }

    public synchronized int getSize() {
        return str.length();
    }

    public static void main(String[] args) throws InterruptedException {
        StringContainer container = new StringContainer();
        FirstThread firstThread = new FirstThread(container);
        SecondThread secondThread = new SecondThread(container);
        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(container.getStr());
    }
}

