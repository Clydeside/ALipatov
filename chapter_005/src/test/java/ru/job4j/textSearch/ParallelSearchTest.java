package ru.job4j.textSearch;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.LinkedList;
import java.util.List;

public class ParallelSearchTest {
    @Test
    public void firstTest() throws InterruptedException {
        String root = "files";
        String text = "Hello";
        List<String> exts = new LinkedList<>();
        exts.add("txt");
        ParallelSearch search = new ParallelSearch(root, text, exts);
        search.init();
        assertThat(search.result().get(0), is("/home/artem/Documents/ALipatov/chapter_005/files/dir1/text.txt"));
    }

    @Test
    public void secondTest() throws InterruptedException {
        String root = "files";
        String text = "Hello";
        List<String> exts = new LinkedList<>();
        exts.add("txt");
        exts.add("xml");
        ParallelSearch search = new ParallelSearch(root, text, exts);
        search.init();
        assertThat(search.result().get(0), is("/home/artem/Documents/ALipatov/chapter_005/files/dir1/textThree.xml"));
        assertThat(search.result().get(1), is("/home/artem/Documents/ALipatov/chapter_005/files/dir1/text.txt"));
    }
}