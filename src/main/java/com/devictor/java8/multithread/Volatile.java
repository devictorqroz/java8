package com.devictor.java8.multithread;

public class Volatile {

    private static int numero = 0;
    private static boolean preparado = false;

    private static class MeuRunnable implements Runnable {
        @Override
        public void run() {
            while (!preparado) {
                // sugere a suspensão temporária da Thread,
                // priorizando outros processos em andamento/pendentes.
                // avisando que "ela não tem algo para fazer".
                Thread.yield();
            }

            System.out.println(numero);
        }
    }

    public static void main(String[] args) {
        Thread t0 = new Thread(new MeuRunnable());
        t0.start();
        numero = 42;
        preparado = true;
    }
}
