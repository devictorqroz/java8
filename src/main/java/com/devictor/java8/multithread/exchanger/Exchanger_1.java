package com.devictor.java8.multithread.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exchanger_1 {

    private static final Exchanger<String> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " toma isso");
            String msg = "Enviando.";
            String retorno = exchange(msg);
            System.out.println(name + " - " + retorno);
        };
        Runnable r2 = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " obrigado");
            String msg = "Obrigado";
            String retorno = exchange(msg);
            System.out.println(name + " - " + retorno);
        };

        executor.execute(r1);
        executor.execute(r2);

        executor.shutdown();
    }

    private static String exchange(String msg) {
        try {
            return EXCHANGER.exchange(msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return "Exceção";
        }
    }


}
