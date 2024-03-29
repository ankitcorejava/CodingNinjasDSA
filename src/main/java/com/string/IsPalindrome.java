package com.string;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsPalindrome {

	public static boolean isPalindrome(String str) {
		// Your code goes here

		if (str == null || str == " ") {
			return false;
		}

		Function<String, String> fun = x -> new StringBuffer(x).reverse().toString();

		// System.out.println(Arrays.asList(str).stream().map(fun).collect(Collectors.toList()).get(0));

		return str.equals(Stream.of(str).map(fun).collect(Collectors.joining(" ")));

	}

	public static void main(String[] args) {
		IsPalindrome.isPalindrome("testing");
	}

}
