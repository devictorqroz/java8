package com.devictor.java8.multithread;

public class Synchronized_1 {

    static int i = -1;

    public static void main(String[] args) {

        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    public static void imprime() {
        synchronized (Synchronized_1.class) {
            i++;
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + i);
        }
    }


    public static class MeuRunnable implements Runnable {
//       static Object Lock1 = new Object();
 //      static Object Lock2 = new Object();

        @Override
//        public synchronized void run() {
        public void run() {

//            imprime();

            synchronized (this) {
                i++;
                String name = Thread.currentThread().getName();
                System.out.println(name + ": " + i);
            }

//          synchronized (Lock1) {
//              i++;
//              String name = Thread.currentThread().getName();
//              System.out.println(name + ": " + i);
//          }
//
//          synchronized (Lock2) {
//              i++;
//              String name = Thread.currentThread().getName();
//              System.out.println(name + ": " + i);
//          }

        }
    }

}
