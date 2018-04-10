package ru.job4j.textSearch;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@ThreadSafe
public class ParallelSearch {
    private final String root;
    private final String text;
    private final List<String> exts;
    private volatile boolean finish = false;

    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();

    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();

    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public void init() throws InterruptedException {
        Thread search = new Thread() {
            @Override
            public void run() {
                synchronized (paths) {
                    Path fileDir = Paths.get(root).toAbsolutePath();
                    MyFileVisitor visitor = new MyFileVisitor(exts);
                    try {
                        Files.walkFileTree(fileDir, visitor);
                        Iterator it = visitor.result().iterator();
                        while (it.hasNext()) {
                            files.add(it.next().toString());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finish = true;
                    paths.notifyAll();
                }
            }
        };
        Thread read = new Thread() {
            @Override
            public void run() {
                synchronized (paths) {
                    while (!finish) {
                        try {
                            paths.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    while (!files.isEmpty()) {
                        String fileName = files.poll();
                        File file = new File(fileName);
                        Scanner scanner = null;
                        try {
                            scanner = new Scanner(file);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        while (scanner.hasNext()) {
                            String line = scanner.nextLine();
                            if (line.contains(text)) {
                                paths.add(fileName);
                            }
                        }
                    }
                }
            }
        };
        search.start();
        read.start();

        search.join();
        read.join();
    }

    public synchronized List<String> result() {
        return this.paths;
    }
}
