package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.models.User;
import static org.junit.Assert.*;

public class UserStorageTest {
    @Test
    public void firstTest() {
        MemoryStorage memory = new MemoryStorage();
        UserStorage storage = new UserStorage(memory);
        storage.add(new User());
    }

    @Test
    public void memoryStorageTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memory = context.getBean(MemoryStorage.class);
        assertThat(memory.getClass().getName(), is("ru.job4j.MemoryStorage"));
    }

    @Test
    public void userStorageTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        assertThat(storage.getClass().getName(), is("ru.job4j.UserStorage"));
        storage.add(new User());
    }

    @Test
    public void userTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        User user = context.getBean(User.class);
        assertThat(user.getClass().getName(), is("ru.job4j.models.User"));
    }
}