package ru.job4j.Sort;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
        Set<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }
}
