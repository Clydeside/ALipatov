package ru.job4j;

import org.springframework.context.ApplicationContext;
import ru.job4j.models.User;

import java.util.List;

public class ImportUser {
    public ApplicationContext context;

    public void showAll(List<User> list) {
        for (User user : list) {
            System.out.println(user);
        }
    }
}
