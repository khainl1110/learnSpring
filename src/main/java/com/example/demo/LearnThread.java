package com.example.demo;

import java.util.concurrent.*;

public class LearnThread {
    public static class NewThread extends Thread{
        public void run() {
            long startTime = System.currentTimeMillis();
            int i = 0;
            while (true) {
                System.out.print(this.getName() + " is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(getRunnable(counter, "Thread 1 final count "));
        Thread thread2 = new Thread(getRunnable(counter, "Thread 2 final count "));

        thread1.start();
        thread2.start();

    }

    private static Runnable getRunnable(Counter counter, String message) {
        return () -> {
            for(int i = 0; i < 1000; i++) {
                counter.incAndGet();
            }
            System.out.println(message + counter.get());
        };
    }
}
