package com.recursion_L2;

/**
 * Given an integer n, using phone keypad find out all the possible strings that
 * can be made using digits of input n.
 * 
 * Return empty string for numbers 0 and 1.
 * 
 * Note : 1. The order of strings are not important. 2. Input and output has
 * already been managed for you. You just have to populate the output array and
 * return the count of elements populated in the output array. Detailed
 * explanation ( Input/output format, Notes, Images ) Constraints : 1 <= n <=
 * 10^6
 * 
 * Sample Input: 23 Sample Output: ad ae af bd be bf cd ce cf
 */

public class LetterComPhoneNumInt {

	public static String[] keyPad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void printKeypad(int input) {
		// Write your code here
		helper_LetterComboOfPhoneNumber(input, "");

	}

	public static void helper_LetterComboOfPhoneNumber(int input, String ansSofar) {

		if (input == 0) {
			System.out.println(ansSofar);
			return;
		}
		String str1 = keyPad[(input % 10)];
		for (int j = 0; j < str1.length(); j++) {

			helper_LetterComboOfPhoneNumber((input / 10), str1.charAt(j) + ansSofar);
		}
	}

	public static void main(String[] args) {

		printKeypad(23);
	}
}
