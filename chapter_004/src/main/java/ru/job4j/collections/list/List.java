package ru.job4j.collections.list;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class List<T> implements SimpleContainer<T> {
    private int modCount = 0;
    private int size = 0;
    private Node head;

    private class Node {
        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    @Override
    public boolean add(T element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        modCount++;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        Node temp = head;
        int n = size;
        T result = null;

        while (index != size)
        {
            index++;
            if (index == size)
                result = temp.data;
            temp = temp.next;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() throws ConcurrentModificationException, NoSuchElementException {
        return new Iterator<T>() {
            int currentModCount = modCount;
            Node temp = head;
            int nextIndex = 0;


            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                if (currentModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                T result = temp.data;
                temp = temp.next;
                nextIndex++;

                return result;
            }
        };
    }
}
