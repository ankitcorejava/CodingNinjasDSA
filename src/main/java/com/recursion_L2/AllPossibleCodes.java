package com.recursion_L2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a
 * numeric string S. Write a program to return the list of all possible codes
 * that can be generated from the given string.
 * 
 * Note : The order of codes are not important. And input string does not
 * contain 0s. Detailed explanation ( Input/output format, Notes, Images ) Input
 * format : A numeric string Constraints : 1 <= Length of String S <= 10
 * 
 * Sample Input: 1123 Sample Output: aabc kbc alc aaw kw
 */
public class AllPossibleCodes {

	public static String[] getCode(String input) {
		// Write your code here
		List<String> ans = new ArrayList<>();
		helper_getCode(input, "", ans);

		List<String> fAns = ans.stream().sorted(Collections.reverseOrder().reversed()).collect(Collectors.toList());
		System.out.println(fAns);
		String[] finalAns = new String[fAns.size()];

		int iCnt = 0;
		for (String str : fAns) {
			finalAns[iCnt] = str;
			iCnt++;
		}
		return finalAns;

	}

	public static void helper_getCode(String input, String codeSoFar, List<String> ans) {

		int a = ((int) 'a') - 1;
		// Base Case:
		if (input == null) {
			return;
		}

		if (input.length() == 0) {
			ans.add(codeSoFar);
			return;
		}
		String subInput = "";
		String first_ch = "";

		if (input.length() >= 2) {
			first_ch = input.substring(0, 2);
			if ((Integer.parseInt(first_ch) >= 10) && (Integer.parseInt(first_ch) <= 26)) {
				subInput = input.replaceFirst(first_ch, "");
				helper_getCode(subInput, (codeSoFar + (char) (a + Integer.parseInt(first_ch))), ans);
			}
		}

		if (input.length() >= 1) {
			first_ch = input.substring(0, 1);
			subInput = input.replaceFirst(first_ch, "");
			helper_getCode(subInput, (codeSoFar + (char) (a + Integer.parseInt(first_ch))), ans);
		}

	}

	public static void main(String[] args) {

		System.out.println(getCode("35411"));
	}

}
