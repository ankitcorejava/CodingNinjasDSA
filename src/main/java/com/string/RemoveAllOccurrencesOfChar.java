package com.string;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllOccurrencesOfChar {
	/*
	 * For a given a string(str) and a character X, write a function to remove all
	 * the occurrences of X from the given string.
	 * 
	 * The input string will remain unchanged if the given character(X) doesn't
	 * exist in the input string.
	 * 
	 * Detailed explanation ( Input/output format, Notes, Images ) Constraints: 0 <=
	 * N <= 10^6 Where N is the length of the input string.
	 * 
	 * Time Limit: 1 second Sample Input 1: aabccbaa a Sample Output 1: bccb Sample
	 * Input 2: xxyyzxx y Sample Output 2: xxzxx
	 */

	public static String removeAllOccurrencesOfChar(String str, char ch) {

		if (str == null || str.length() < 1) {
			return null;
		}

		StringBuffer strBuf = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {			
			if (str.charAt(i) != ch) {
				strBuf.append(str.charAt(i));
			}
		}
		return strBuf.toString();
	}

	public static void main(String[] args) {
		System.out.println(RemoveAllOccurrencesOfChar.removeAllOccurrencesOfChar("xxyyzxx",'y'));
	}

}
