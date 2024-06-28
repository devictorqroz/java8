package com.devictor.java8.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueue_1 {

    private static final SynchronousQueue<String> FILA =
            new SynchronousQueue<>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            put();
            System.out.println("Inseriu");
        };
        Runnable r2 = () -> {
            String msg = take();
            System.out.println("Coletou " + msg);
        };

        executor.execute(r1);
        executor.execute(r2);

        executor.shutdown();
    }

    private static String take() {
        try {
//            return FILA.poll(timeout, unit);
            return FILA.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return "Exceção";
        }
    }

    private static void put() {
        try {
//            FILA.offer(e, timeout, unit);
            FILA.put("Inserindo");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
