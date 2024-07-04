package com.devictor.java8.multithread.threadsandrunnable;

public class MeuRunnable implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
