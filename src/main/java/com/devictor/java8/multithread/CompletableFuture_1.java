package com.devictor.java8.multithread;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture_1 {

    public static void main(String[] args) {

        CompletableFuture<String> processe = processe();

        CompletableFuture<String> thenApply =
                processe.thenApply(s -> s + " xD");

        CompletableFuture<Void> thenAccept =
                thenApply.thenAccept(s -> System.out.println(s));

        System.out.println("Estudando Completable Future ");

        sleep();
        sleep();
        sleep();

    }

    private static CompletableFuture<String> processe() {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            return "Estudando completable future!";
        });
    }

    private static final void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}
