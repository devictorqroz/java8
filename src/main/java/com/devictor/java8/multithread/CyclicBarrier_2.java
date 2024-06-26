package com.devictor.java8.multithread;

import java.util.concurrent.*;

public class CyclicBarrier_2 {

    private static BlockingQueue<Double> resultados =
            new LinkedBlockingQueue<>();

    // 432*3 + 3^14 + 45*127/12 = ?
    public static void main(String[] args) {

        Runnable finalizacao = () -> {
            System.out.println("Somando tudo");
            double resultadoFinal = 0;
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            System.out.println("Processamento finalizado. "
                    + "Resultado final: " + resultadoFinal);
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, finalizacao);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable r1 = () -> {
            resultados.add(432*3d);
            await(cyclicBarrier);
        };
        Runnable r2 = () -> {
            resultados.add(Math.pow(3d, 14d));
            await(cyclicBarrier);
        };
        Runnable r3 = () -> {
            resultados.add(45d*127d/12d);
            await(cyclicBarrier);
        };

        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);

        executor.shutdown();

    }

    private static void await(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}
