package ru.job4j.concurrency.waitNotify;

public class PoolThread extends Thread {

    private SimpleBlockingQueue taskQueue = null;
    private boolean       isStopped = false;

    public PoolThread(SimpleBlockingQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void run(){
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.peek();
                runnable.run();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}