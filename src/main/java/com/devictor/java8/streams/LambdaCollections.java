package com.devictor.java8.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LambdaCollections {

    public static void main(String[] args) {

        // List
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // forEach
        list.forEach(n -> System.out.println(n));

        // removeIf
        list.removeIf(n -> n % 2 == 0);
        list.forEach(n -> System.out.println(n));

        // replaceAll
        list.replaceAll(n -> n * 2);
        list.forEach(n -> System.out.println(n));

        // Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Duke");
        map.put(1, "is");
        map.put(2, "a");
        map.put(3, "dude");

        // forEach
        map.forEach((k, v) -> System.out.println(k + v));


        // compute
        map.compute(0, (k, v) -> v + " I am your father!");
        map.forEach((k, v) -> System.out.println(k + v));


        // merge
        map.merge(3, "!", (v1, v2) -> v1 + v2);
        map.forEach((k, v) -> System.out.println(k + v));


        // replaceAll
        map.replaceAll((k, v) -> v + "!");
        map.forEach((k, v) -> System.out.println(k + v));


    }

}
