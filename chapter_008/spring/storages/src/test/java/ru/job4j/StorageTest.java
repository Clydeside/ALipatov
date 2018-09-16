package ru.job4j;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.models.User;
import ru.job4j.storages.MemoryStorage;

public class StorageTest {
    @Test
    public void firstTest() {
        ImportUser importUser = new ImportUser();
        importUser.context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage storage = importUser.context.getBean(MemoryStorage.class);
        storage.add(new User("First user"));
        storage.add(new User("Second user"));
        importUser.showAll(storage.getAll());
    }
}
