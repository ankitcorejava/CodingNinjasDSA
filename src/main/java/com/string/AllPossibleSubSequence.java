package com.string;

import java.util.Scanner;

public class AllPossibleSubSequence {

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
	public static void printSubstrings(String str,String ans) {
		// Your code goes here

		if (str == null || str.isBlank()) {
			System.out.println(ans);
			return;
		}

		char firstChar = str.charAt(0); // a
		String substr = str.substring(1, str.length());
		printSubstrings(substr,ans +firstChar);
		printSubstrings(substr,ans +"_");
		
	}

	public static void main(String[] args) {
		AllPossibleSubSequence.printSubstrings("abc"," ");
		Scanner scan = new Scanner(System.in);
	}

}
