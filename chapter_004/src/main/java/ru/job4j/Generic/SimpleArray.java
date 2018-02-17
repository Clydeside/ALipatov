package ru.job4j.Generic;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index < objects.length;
            }

            @Override
            public T next() {
                return (T) objects[index++];
            }
        };
    }

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void set(int index, T model) throws NullPointerException {
        this.objects[index] = model;
    }

    public void delete(int index) {
        Object[] array = new Object[objects.length - 1];
        objects[index] = null;
        int count = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                array[count] = objects[i];
                count++;
            }
        }
        objects = new Object[objects.length - 1];
        this.index = 0;
        for (int i = 0; i < objects.length; i++) {
            this.objects[this.index++] = array[i];
        }
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    public Object[] getAll() {
        return objects;
    }
}
