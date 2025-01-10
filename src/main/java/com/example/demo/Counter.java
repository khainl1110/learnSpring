package com.example.demo;

public class Counter {
    private long count = 0;

    public long incAndGet() {
        synchronized (this) {
            this.count++;
            return this.count;
        }

    }

    public long get() {
        synchronized (this) {
            return this.count;
        }
    }
}
