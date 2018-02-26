package ru.job4j.concurrency.threads;

import java.util.StringTokenizer;

public class AsyncOperations {

    public static void main(String[] args) {
        String str = "This is a string to operate.";
        new Thread() {
            @Override
            public void run() {
                char[] arr = str.toCharArray();
                int countSpaces = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == ' ') {
                        countSpaces++;
                    }
                }
                System.out.println(countSpaces);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                int countWords = 0;
                for(int e = 0; e < str.length(); e++){
                    if(str.charAt(e) != ' '){
                        countWords++;
                        while(str.charAt(e) != ' ' && e < str.length()-1){
                            e++;
                        }
                    }
                }
                System.out.println(countWords);
            }
        }.start();


    }
}
