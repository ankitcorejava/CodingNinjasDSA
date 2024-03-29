package com.string;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWord {

	public static String reverseEachWord(String str) {
		
		
		 String[] strArray= str.split(" ");

		Function<String, String> fns = x -> new StringBuilder(x).reverse().toString();

		//Stream.of(strArray).map(fns).forEach(x -> System.out.print(x+ " "));

		return Stream.of(strArray).map(fns).collect(Collectors.joining(" "));
	}

	public static void main(String[] args) {
		ReverseEachWord.reverseEachWord("Spring Boot");
	}

}
