package com.devictor.java8.multithread;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorsScheduled {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

//        ScheduledFuture<String> future = executor.schedule(new Tarefa(), 2, TimeUnit.SECONDS);
//        executor.schedule(new Tarefa(), 2, TimeUnit.SECONDS);

//        System.out.println(future.get());

//        executor.scheduleAtFixedRate(new Tarefa(), 0, 1, TimeUnit.SECONDS);

        executor.scheduleWithFixedDelay(new Tarefa(), 0, 1, TimeUnit.SECONDS);


//        executor.shutdown();
    }

//    public static class Tarefa implements Callable<String> {
    public static class Tarefa implements Runnable {
        @Override
//        public String call() throws Exception {
        public void run() {
            try {
//                Thread.sleep(500);
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(LocalTime.now());
            String name = Thread.currentThread().getName();
            int nexInt = new Random().nextInt(1000);
            System.out.println(name + " tarefa " + nexInt);
//            return name + " tarefa " + nexInt;
        }

    }

}
