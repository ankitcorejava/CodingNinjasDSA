package com.string;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubSequenceWithList {

	/*
	 * For a given input string(str), write a function to print all the possible
	 * substrings.
	 * 
	 * Substring A substring is a contiguous sequence of characters within a string.
	 * Example: "cod" is a substring of "coding". Whereas, "cdng" is not as the
	 * characters taken are not contiguous
	 * 
	 * Sample Input 1: abc Sample Output 1: a ab abc b bc c
	 */

	/*
	 * a -> 0 a -> a ====== ab -> 00 both not present; ab -> a0 - only a present; ab
	 * -> 0b - only b present; ab - > ab - both are present:
	 * 
	 * L_of_Faith: ab -> a(b - possibility) & 0 (b - possibility);
	 * 
	 */
	public static List<String> printSubstrings(String str) {
		// Your code goes here

		if (str == null || str.isBlank()) {
			List<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		char firstChar = str.charAt(0); // a
		String substr = str.substring(1, str.length());
		List<String> subAns = printSubstrings(substr);
		List<String> finalList = new ArrayList<>();

		// With a
		for (String str1 : subAns) {
			finalList.add(firstChar + str1);
		}

		// WithOut a
		for (String str1 : subAns) {
			finalList.add("" + str1);
		}
		return finalList;

	}

	public static void main(String[] args) {
		List<String> finalList = AllPossibleSubSequenceWithList.printSubstrings("xyz");
		finalList.stream().sorted().forEach(x -> System.out.println(x));
	}

}
