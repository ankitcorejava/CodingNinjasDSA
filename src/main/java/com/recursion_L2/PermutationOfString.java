package com.recursion_L2;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem statement Given a string S, find and return all the possible
 * permutations of the input string.
 * 
 * Note 1 : The order of permutations is not important. Note 2 : If original
 * string contains duplicate characters, permutations will also be duplicates.
 * Detailed explanation ( Input/output format, Notes, Images ) Sample Input :
 * abc Sample Output : abc acb bac bca cab cba
 */
public class PermutationOfString {

	public static String[] permutationOfString(String input) {
		// Write your code here
		List<String> outPutList = helper_permutationOfString(input);
		String[] arrayOut = new String[outPutList.size()];
		int iCnt = 0;
		for (String s : outPutList) {
			arrayOut[iCnt] = s;
			iCnt++;
		}

		return arrayOut;
	}

	public static List<String> helper_permutationOfString(String input) {
		// Write your code here

		// Base Case:
		if (input == null) {
			return null;
		}

		if (input.length() == 0) {
			List<String> baseAns = new ArrayList<String>();
			baseAns.add("");
			return baseAns;
		}
		List<String> ans = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
			char firstCh = input.charAt(i);
			String subInput = input.replaceFirst(firstCh + "", "").trim();
			List<String> subAns = helper_permutationOfString(subInput);
			for (String str : subAns) {
				ans.add(firstCh + str);
			}

		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(helper_permutationOfString("fsnafan"));
	}

}
