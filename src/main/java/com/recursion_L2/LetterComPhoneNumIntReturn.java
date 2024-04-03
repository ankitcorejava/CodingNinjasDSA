package com.recursion_L2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

public class LetterComPhoneNumIntReturn {

	public static String[] keyPad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static String[] keypad(int n) {
		// Write your code here

		List<String> list = new ArrayList<>();
		helper_LetterComboOfPhoneNumber(n, "", list);

		list = list.stream().sorted().collect(Collectors.toList());

		String[] arr = list.toArray(new String[list.size()]);
		//Arrays.sort(arr);

		//System.out.println(list);
		return arr;

	}

	public static void helper_LetterComboOfPhoneNumber(int input, String ansSofar, List<String> list) {

		if (input == 0) {
			// System.out.println(ansSofar);
			list.add(ansSofar);
			return;
		}
		String str1 = keyPad[(input % 10)];
		for (int j = 0; j < str1.length(); j++) {

			helper_LetterComboOfPhoneNumber((input / 10), str1.charAt(j) + ansSofar, list);
		}
	}

	public static void main(String[] args) {

		keypad(23);
	}
}
