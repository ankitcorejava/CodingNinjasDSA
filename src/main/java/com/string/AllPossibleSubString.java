package com.string;

public class AllPossibleSubString {

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

	public static void printSubstrings(String str) {

		// str.substring(0, 0) -- begin index & end index;

		for (int i = 0; i < str.length(); i++) {

			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}

	}

	public static void main(String[] args) {
		AllPossibleSubString.printSubstrings("abc");
	}

}
