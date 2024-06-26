package com.devictor.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// com method reference
		list.stream()
				.forEach(System.out::println);


		// sem method reference
		list.stream()
				.forEach((n) -> System.out.println(n));


		// métodos estáticos
		list.stream()
				.map((n) -> multipliquePorDois(n))
				.forEach(System.out::println);

		list.stream()
				.map(MethodReference::multipliquePorDois)
				.forEach(System.out::println);


		// construtores
		list.stream()
				.map((n) -> new BigDecimal(n))
				.forEach(System.out::println);

		list.stream()
				.map(BigDecimal::new)
				.forEach(System.out::println);


		//várias instâncias
		list.stream()
				.map((n) -> n.doubleValue())
				.forEach(System.out::println);

		list.stream()
				.map(Integer::doubleValue)
				.forEach(System.out::println);


		//única instância
		BigDecimal dois = new BigDecimal(2);
		list.stream()
				.map(BigDecimal::new)
				.map((b) -> dois.multiply(b))
				.forEach(System.out::println);

		list.stream()
				.map(BigDecimal::new)
				.map(dois::multiply)
				.forEach(System.out::println);

	}

	private static Integer multipliquePorDois(Integer i) {
		return i * 2;
	}
}
