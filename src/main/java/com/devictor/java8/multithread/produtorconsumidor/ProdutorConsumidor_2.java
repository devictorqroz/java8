package com.devictor.java8.multithread.produtorconsumidor;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// MultiThread - Produtor-Consumidor.
// Critical Section (Seção / Região crítica).
// Mutex - Mutual exclusion, exclusão mútua.
public class ProdutorConsumidor_2 {

    private static final BlockingQueue<Integer> FILA =
            new LinkedBlockingQueue<>(5);
    private static volatile boolean produzindo = true;
    private static volatile boolean consumindo = true;
    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {

        Thread produtor = new Thread(() -> {
            while (true) {
                try {
                    simulaProcessamento();
                    if (produzindo) {
                        LOCK.lock();
                        System.out.println("Produzindo");
                        int numero = new Random().nextInt(10000);
                        FILA.add(numero);
                        if (FILA.size() == 5) {
                            System.out.println("Pausando produtor");
                            produzindo = false;
                        }
                        if (FILA.size() == 1) {
                            System.out.println("Iniciando consumidor");
                            consumindo = true;
                        }
                        LOCK.unlock();
                    } else {
                        System.out.println("### Produtor dormindo!");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        Thread consumidor = new Thread(() -> {
            while (true) {
                try {
                    simulaProcessamento();
                    if (consumindo) {
                        LOCK.lock();
                        System.out.println("Consumindo");
                        Optional<Integer> numero = FILA.stream().findFirst();
                        numero.ifPresent(n -> {
                            FILA.remove(n);
                        });
                        if (FILA.size() == 0) {
                            System.out.println("Pausando consumidor");
                            consumindo = false;
                        }
                        if (FILA.size() == 4) {
                            System.out.println("Iniciando produtor");
                            produzindo = true;
                        }
                        LOCK.unlock();
                    } else {
                        System.out.println("### Consumidor dormindo!");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });


        produtor.start();
        consumidor.start();
    }


    private static final void simulaProcessamento() {
        int tempo = new Random().nextInt(10);
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
