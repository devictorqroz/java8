package com.devictor.java8.multithread.produtorconsumidor;

import java.util.Random;
import java.util.concurrent.*;

// MultiThread - Produtor-Consumidor.
public class ProdutorConsumidor_3 {

    private static final BlockingQueue<Integer> FILA =
            new LinkedBlockingQueue<>(5);


//    private static volatile boolean produzindo = true;
//    private static volatile boolean consumindo = true;
//    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {


//        Runnable produtor = () -> {
//            try {
//                simulaProcessamento();
//                if (produzindo) {
//                    LOCK.lock();
//                    System.out.println("Produzindo");
//                    int numero = new Random().nextInt(10000);
//                    FILA.add(numero);
//                    if (FILA.size() == 5) {
//                        System.out.println("Pausando produtor");
//                        produzindo = false;
//                    }
//                    if (FILA.size() == 1) {
//                        System.out.println("Iniciando consumidor");
//                        consumindo = true;
//                    }
//                    LOCK.unlock();
//                } else {
//                    System.out.println("### Produtor dormindo!");
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        };


//        Runnable consumidor = () -> {
//            try {
//                simulaProcessamento();
//                if (consumindo) {
//                    LOCK.lock();
//                    System.out.println("Consumindo");
//                    Optional<Integer> numero = FILA.stream().findFirst();
//                    numero.ifPresent(n -> {
//                        FILA.remove(n);
//                    });
//                    if (FILA.size() == 0) {
//                        System.out.println("Pausando consumidor");
//                        consumindo = false;
//                    }
//                    if (FILA.size() == 4) {
//                        System.out.println("Iniciando produtor");
//                        produzindo = true;
//                    }
//                    LOCK.unlock();
//                } else {
//                    System.out.println("### Consumidor dormindo!");
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        };


        Runnable produtor = () -> {
//            simulaProcessamento();
            simulaProcessamentoLento();
            System.out.println("Produzindo");
            int numero = new Random().nextInt(10000);
            try {
                FILA.put(numero);
                System.out.println(numero);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        Runnable consumidor = () -> {
//            simulaProcessamento();
            simulaProcessamentoLento();
            System.out.println("Consumindo");
            try {
                Integer take = FILA.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(produtor, 0, 10, TimeUnit.MILLISECONDS);
        executor.scheduleWithFixedDelay(consumidor, 0, 10, TimeUnit.MILLISECONDS);

    }

    private static final void simulaProcessamento() {
        int tempo = new Random().nextInt(40);
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static final void simulaProcessamentoLento() {
        int tempo = new Random().nextInt(1000);
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}
