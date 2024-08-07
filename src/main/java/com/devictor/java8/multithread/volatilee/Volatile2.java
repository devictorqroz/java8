package com.devictor.java8.multithread.volatilee;

public class Volatile2 {

//    private static int numero = 0;
//    private static boolean preparado = false;
    private static volatile int numero = 0;
    private static volatile boolean preparado = false;

    private static class MeuRunnable implements Runnable {
        @Override
        public void run() {
            while (!preparado) {
                Thread.yield();
            }

            if (numero != 42) {
                System.out.println(numero);
//                throw new IllegalStateException(".");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread t0 = new Thread(new MeuRunnable());
            t0.start();
            Thread t1 = new Thread(new MeuRunnable());
            t1.start();
            Thread t2 = new Thread(new MeuRunnable());
            t2.start();

            numero = 42;
            preparado = true;

            while (
                t0.getState() != Thread.State.TERMINATED
                || t1.getState() != Thread.State.TERMINATED
                || t2.getState() != Thread.State.TERMINATED
                ) {
                // espera
            }

            numero = 0;
            preparado = false;
        }

    }

}
