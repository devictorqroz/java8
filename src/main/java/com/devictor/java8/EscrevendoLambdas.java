package com.devictor.java8;

import java.util.stream.IntStream;

public class EscrevendoLambdas {

	public static void main(String[] args) {
	
	
		// escrevendo funcoes lambdas
		
		// parenteses obrigatorios
		
		Runnable runnable = () -> System.out.println("code java!");
		
		IntStream.range(0, 11)
			.filter((int n) -> n % 2 == 0)
			.reduce((n1, n2) -> n1 + n2)
			.ifPresent(System.out::println);
			
	
		// chaves
						
		IntStream.range(0, 11)
			.filter((int n) -> { 
				System.out.println("code java");
				return n % 2 == 0; 
			})
			.forEach(n -> System.out.println(n)); // simples
		
	}
}
