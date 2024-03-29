package com.string;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

	public static String stringReverse(char[] arr) {
		
		String strs = new String(arr);

		Function<String, String> fnn = x -> new StringBuffer(x).reverse().toString();

		return Stream.of(strs).map(fnn).collect(Collectors.joining(" "));		
		

	}

	public static void main(String[] args) {
		System.out.println(ReverseString.stringReverse("testing".toCharArray()));
	}

}
