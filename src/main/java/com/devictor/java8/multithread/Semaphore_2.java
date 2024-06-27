package com.devictor.java8.multithread;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Semaphore_2 {

    private static final Semaphore SEMAFORO = new Semaphore(3);

    private static final AtomicInteger QTD = new AtomicInteger(0);

    public static void main(String[] args) {

//        ExecutorService executor = Executors.newCachedThreadPool();
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(21);

        Runnable r1 = () -> {
            String name = Thread.currentThread().getName();
            int usuario = new Random().nextInt(10000);

            boolean conseguiu = false;
            QTD.incrementAndGet();
            while (!conseguiu) {
                conseguiu = tryAcquire();
            }
            QTD.decrementAndGet();

            System.out.println("Usuário "
                    + usuario
                    + " na Thread "
                    + name + "\n");

            sleep();
            SEMAFORO.release();
        };

        Runnable r2 = () -> {
            System.out.println(QTD.get());
        };

        for (int i = 0; i < 20; i++) {
            executor.execute(r1);
        }

        executor.scheduleWithFixedDelay(r2, 0, 400, TimeUnit.MILLISECONDS);

//        executor.shutdown();

    }

    private static void sleep() {
        // tempo de espera de 1 a 6 segundos
        try {
            int tempoEspera = new Random().nextInt(6);
            tempoEspera++;
            Thread.sleep(1000 * tempoEspera);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static boolean tryAcquire() {
        try {
            return SEMAFORO.tryAcquire(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return false;
        }
    }


}
