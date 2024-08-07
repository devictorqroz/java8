package com.devictor.java8.multithread.threadsafecollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SincronizarColecoes {

    private static List<String> lista = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        // Utilize a versão do synchronized de acordo com a Collection
        lista = Collections.synchronizedList(lista);

        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(500);

        System.out.println(lista);

    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            lista.add("#");
            String name = Thread.currentThread().getName();
            System.out.println(name + " inseriu");
        }

    }

}
