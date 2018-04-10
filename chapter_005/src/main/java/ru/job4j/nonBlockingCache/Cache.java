package ru.job4j.nonBlockingCache;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class Cache {
    private ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();

    public User getValue(Integer key) {
        return map.get(key);
    }

    public boolean add(Integer key, User user) {
        map.put(key, user);
        return true;
    }

    public void update(Integer key, User value) {
        map.computeIfPresent(key, (k, oldValue) -> {
            int oldV = oldValue.getVersion();
            if (oldV != value.getVersion()) {
                throw new OptimisticException();
            }
            map.get(key).incrementVersion();
            return value;
        });
    }

    public boolean delete(Integer key) {
        map.remove(key);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cache cache = (Cache) o;

        return map != null ? map.equals(cache.map) : cache.map == null;
    }

    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }

    private class OptimisticException extends RuntimeException {
        public OptimisticException() {
            super("Optimistic Exception!");
        }
    }
}
