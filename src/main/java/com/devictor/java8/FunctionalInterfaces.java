package com.devictor.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        /*
         * Interface Stream
         *
         * @FunctionalInterface - Interfaces Funcionais
         */


        /*
         * Supplier (fornecedor) - Recebe nada, entrega um valor.
         *
         *  @FunctionalInterface
         *  public interface Supplier<T> {
         *      T get();
         *  }
         *
         * Supplier - generate()
         */
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);



        /*
         * Consumer (consumidor) - Recebe um valor, retorna nada.
         * BiConsumer (consumidor) - Recebe dois valores, retorna nada.
         *
         * @FunctionalInterface
         * public interface Consumer<T> {
         *      void accept(T t);
         * }
         *
         * @FunctionalInterface
         * public interface BiConsumer<T, U> {
         *      void accept(T t, U u);
         * }
         *
         * Consumer - forEach()
         */
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach((e) -> System.out.println(e));



        /*
         * Predicate - Função que recebe um valor e retorna um booleano.
         * BiPredicate - Função que recebe dois valores e retorna um booleano.
         *
         * @FunctionalInterface
         * public interface Predicate<T> {
         *      boolean test(T t);
         * }
         *
         * @FunctionalInterface
         * public interface BiPredicate<T, U> {
         *      boolean test(T t, U u);
         * }
         *
         * Predicate - filter()
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);



        /*
         * Interface Funcional mais genérica de todas.
         *
         * Function - Função que recebe um valor e retorna um valor.
         * BiFunction - Função que recebe dois valores e retorna um valor.
         *
         * @FunctionalInterface
         * public interface Function<T, R> {
         *      R apply(T t);
         * }
         *
         * @FunctionalInterface
         * public interface BiFunction<T, U, R> {
         *      R apply(T t, U u);
         * }
         *
         * Function - map()
         */
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e.doubleValue())
                .forEach(System.out::println);




        /*
         * Extendem Function
         *
         * UnaryOperator - Extends Function<T, T>
         * BinaryOperator - Extends BiFunction<T, T, T>
         *
         * @FunctionalInterface
         * public interface UnaryOperator<T> extends Function<T, T> {
         *     static <T> UnaryOperator<T> identity() {
         *          return t -> t;
         *     }
         * }
         *
         * @FunctionalInterface
         * public interface BinaryOperator<T> extends BiFunction<T, T, T> {
         *    //...
         * }
         *
         * BinaryOperator - reduce()
         */
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e.doubleValue())
                .reduce((e1, e2) -> e1 + e2)
                .ifPresent(System.out::println);



    }




}
