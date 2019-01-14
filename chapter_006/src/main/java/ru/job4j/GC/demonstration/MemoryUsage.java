package ru.job4j.GC.demonstration;

public class MemoryUsage {
    public static int kb = 1;

    public static void info() {

        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [KB] #####");

        //Print used memory
        System.out.println("Used Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / kb);

        //Print free memory
        System.out.println("Free Memory:"
                + runtime.freeMemory() / kb);

        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / kb);

        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / kb);
    }

    public static long diff() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.freeMemory() / kb;
    }

    public static void main(String[] args) {
        info();
        long initialDiff = diff();
        User user = new User();
        long finalDiff = diff();
        System.out.println(initialDiff - finalDiff);
        info();
        System.gc();
    }
}
