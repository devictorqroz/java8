package com.devictor.java8;

import java.util.Arrays;
import java.util.List;

public class DebugLambda {

    // Debug Lambda
    // Bloco
    // Método
    // Peek


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 5, 8, 9);

        list.stream()
                .map((n) -> new StringBuilder().append(n).append("s").append("a"))
                .forEach(System.out::println);

        
        // debug com bloco
        list.stream()
                .map((n) -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(n);
                    builder.append("s");
                    builder.append("a");
                    return builder;
                })
                .forEach(System.out::println);


        // debug com método
        list.stream()
                .map((n) -> getStringBuilder(n))
                .forEach(System.out::println);


        // debug com peek
        list.stream()
                .peek(n -> System.out.println(n + " antes do filter"))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println(n + " depois do filter"))
                .forEach(System.out::println);


    }

    // método extraído
    private static StringBuilder getStringBuilder(Integer n) {
        StringBuilder builder = new StringBuilder();
        builder.append(n);
        builder.append("s");
        builder.append("a");
        return builder;
    }

}
