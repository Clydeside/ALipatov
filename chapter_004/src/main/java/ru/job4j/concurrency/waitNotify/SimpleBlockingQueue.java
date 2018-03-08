package ru.job4j.concurrency.waitNotify;

import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    final private Queue<T> queue = new LinkedList<>();
    private final Object lock = new Object();
    private int capacity = 2;

    public void offer(T value) throws InterruptedException {
        synchronized (lock) {
            lock.notify();
            while (queue.size() >= capacity) {
                System.out.println("Producing...");
                lock.wait();
            }
            queue.add(value);
        }
    }

    public T peek() throws InterruptedException {
        synchronized (lock) {
            lock.notify();
            while (queue.isEmpty()) {
                System.out.println("Consuming");
                lock.wait();
            }
            return queue.poll();
        }
    }

    public synchronized int size() {
        return queue.size();
    }
}
