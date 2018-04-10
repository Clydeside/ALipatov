package ru.job4j.bomberMan;

import ru.job4j.bomberMan.models.Hero;

import java.util.concurrent.locks.ReentrantLock;

public class Board {
    private final int size;
    private final ReentrantLock[][] board;

    public int getSize() {
        return size;
    }

    public ReentrantLock[][] getBoard() {
        return board;
    }

    public Board(int size) {
        this.size = size;
        this.board = new ReentrantLock[size][size];
    }

    public void start(int x, int y) {
        Thread place = new Thread() {
            @Override
            public void run() {
                Hero hero = new Hero(x, y);
                board[x][y].lock();
            }
        };
        Thread move = new Thread() {
            @Override
            public void run() {
                if (board[x][y].tryLock()) {
                }
            }
        };
    }
}
