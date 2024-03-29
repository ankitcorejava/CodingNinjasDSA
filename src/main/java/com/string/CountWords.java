package com.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountWords {

	public static int countWords(String str) {
		// Your code goes here
		String[] strArray = str.split(" ");

		// return Arrays.asList(str).stream().collect(Collectors.counting()).intValue();
		return Arrays.asList(strArray).stream().collect(Collectors.counting()).intValue();
	}

	public static void main(String[] args) {
		System.out.println(CountWords.countWords("this is a sample string"));
	}
}
