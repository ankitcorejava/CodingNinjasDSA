package com.string;

import java.util.ArrayList;
import java.util.List;

public class RemoveConsecutiveDuplicates {
	/*
	 * For a given string(str), remove all the consecutive duplicate characters.
	 * 
	 * Example: Input String: "aaaa" Expected Output: "a"
	 * 
	 * Input String: "aabbbcc" Expected Output: "abc" Input Format: The first and
	 * only line of input contains a string without any leading and trailing spaces.
	 * All the characters in the string would be in lower case. Output Format: The
	 * only line of output prints the updated string. Note: You are not required to
	 * print anything. It has already been taken care of. Constraints: 0 <= N <=
	 * 10^6 Where N is the length of the input string.
	 * 
	 * Time Limit: 1 second Constraints: 0 <= N <= 10^6 Where N is the length of the
	 * input string.
	 * 
	 * Time Limit: 1 second Sample Input 1: aabccbaa Sample Output 1: abcba Sample
	 * Input 2: xxyyzxx Sample Output 2: xyzx
	 * 
	 */

	public static String removeConsecutiveDuplicates(String str) {

		if (str == null || str.length() < 1) {
			return null;
		}

		StringBuffer strBuf = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {

			if (strBuf.length() == 0) {
				strBuf.append(str.charAt(i));
			} else if (strBuf.charAt(strBuf.length() - 1) == str.charAt(i)) {
				strBuf.deleteCharAt(strBuf.length() - 1);
				strBuf.append(str.charAt(i));
			} else {
				strBuf.append(str.charAt(i));
			}

		}
		return strBuf.toString();
	}

	public static void main(String[] args) {
		System.out.println(RemoveConsecutiveDuplicates.removeConsecutiveDuplicates("aaaaa"));
	}

}
