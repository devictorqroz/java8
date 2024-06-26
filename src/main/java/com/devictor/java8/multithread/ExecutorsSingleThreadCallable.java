package com.devictor.java8.multithread;

import java.util.Random;
import java.util.concurrent.*;

public class ExecutorsSingleThreadCallable {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = null;

        try {
            executor = Executors.newSingleThreadExecutor();

            Future<String> future = executor.submit(new Tarefa());

            System.out.println(future.isDone());
//            System.out.println(future.get());
            System.out.println(future.get(1, TimeUnit.SECONDS));
            System.out.println(future.isDone());

//            executor.shutdown();
//            executor.awaitTermination(10, TimeUnit.SECONDS);
//            System.out.println(future.isDone());
        } catch (Exception e) {
            throw e;
        } finally {
            if (executor != null) {
//                executor.shutdown();
                executor.shutdownNow();
            }
        }
    }

    public static class Tarefa implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(500);
            String name = Thread.currentThread().getName();
            int nextInt = new Random().nextInt(1000);
            return name + " executando tarefa " + nextInt;
        }
    }


}
