package com.recursion_L2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an String n, using phone keypad find out all the possible strings that
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

public class LetterCombinationOfPhoneNumber {

	public static String[] keyPad = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	public static void helper_LetterComboOfPhoneNumber(String str, String ansSofar, List<String> ansList) {

		if (str.length() == 0) {
			System.out.println(ansSofar);
			ansList.add(ansSofar);
			return;
		}

		// for (int i = 0; i < str.length(); i++) {

		// System.out.println(str.charAt(i) - '0');

		int charInput = str.charAt(0) - '0';
		// System.out.println(keyPad[charInput]);

		String str1 = keyPad[charInput];

		for (int j = 0; j < str1.length(); j++) {

			helper_LetterComboOfPhoneNumber(str.substring(1), ansSofar + str1.charAt(j), ansList);

		}

	}

	public static void main(String[] args) {

		helper_LetterComboOfPhoneNumber("234", "", new ArrayList<>());
	}
}
