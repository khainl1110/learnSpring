package com.example.demo.domain;

public class LearnThread {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getState());
    }

    public class NewThread extends Thread{
        
    }
}
