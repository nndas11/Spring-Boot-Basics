package com.example.demo.multithreading;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Multithread thread = new Multithread(i);
            thread.start();
        }

        for (int i = 0; i < 5; i++) {
            Multithreading thread11 = new Multithreading(i);
            Thread thread1 = new Thread(thread11);
            thread1.start();
        }

    }
}
