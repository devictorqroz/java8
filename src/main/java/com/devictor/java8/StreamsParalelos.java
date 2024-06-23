package com.devictor.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsParalelos {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // parallel vs parallelStream
        // list.parallelStream()
        // IntStream.range(0, 5).parallel()

        //forEach x forEachOrdered
        // itera de forma paralela, "aleatória" sobre os itens da lista.
        list.parallelStream()
            .forEach(System.out::println);

        System.out.println("---");


        // itera de forma ordenada, mantendo a ordem dos elementos na lista.
        list.parallelStream()
            .forEachOrdered(System.out::println);

        System.out.println("---");


        // findAny
        list.parallelStream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("---");


        list.stream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("---");


        // unordered: skip, limit, distinct
        list.parallelStream()
                .unordered()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);


        // reduce = operação associativa  (soma, multiplicação)
        // (1 + 2) + (3 + 4) = 10 - é associativa
        // (1 - 2) - (3 - 4) != 10 - não é associativa
        list.parallelStream()
                .reduce((n1, n2) -> n1 - n2)
                .ifPresent(System.out::println);

        System.out.println("---");


        // collect

        // toMap - cria um mapa para cada thread.
        Map<Integer, Boolean> collect =
            list.parallelStream()
                .collect(
                    Collectors.toMap(n -> n, n -> n % 2 == 0)
                );
        System.out.println(collect);

        System.out.println("---");


        // toConcurrentMap - cria um único mapa compartilhado entre as threads.
        // pode perder a ordem os elementos.
        Map<Integer, Boolean> collect2 =
                list.parallelStream()
                    .collect(
                        Collectors
                        .toConcurrentMap(n -> n, n -> n % 2 == 0)
                    );
        System.out.println(collect2);

        System.out.println("---");


        // groupingByConcurrent
        // pode perder a ordem os elementos.
        Map<Boolean, List<Integer>> collect3 =
            list.parallelStream()
                .collect(
                    Collectors
                    .groupingByConcurrent(n -> n % 2 == 0)
                );
        System.out.println(collect3);


    }


}
