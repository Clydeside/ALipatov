package ru.job4j.nonBlockingCache;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class Cache {
    @GuardedBy("this")
    private ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();

    @GuardedBy("this")
    private final Object lock = new Object();

    public User getValue(Integer key) {
        synchronized (lock) {
            return map.get(key);
        }
    }

    public boolean add(Integer key, User user) {
        synchronized (lock) {
            map.put(key, user);
        }
        return true;
    }

    public void update(Integer key, User value) {
        synchronized (lock) {
            if (!value.getVersion().equals(map.get(key).getVersion())) {
                throw new OptimisticException();
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (pair.getKey().equals(key)) {
                    pair.setValue(value);
                }
            }
            map.get(key).incrementVersion();
        }
    }

    public boolean delete(Integer key) {
        synchronized (lock) {
            map.remove(key);
        }
        return true;
    }

    private class OptimisticException extends RuntimeException {
        public OptimisticException() {
            super("Optimistic Exception!");
        }
    }
}
