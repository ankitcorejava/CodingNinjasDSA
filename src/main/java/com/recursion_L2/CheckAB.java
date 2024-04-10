package com.recursion_L2;

/**
 * Suppose you have a string, S, made up of only 'a's and 'b's. Write a
 * recursive function that checks if the string was generated using the
 * following rules:
 * 
 * a. The string begins with an 'a' b. Each 'a' is followed by nothing or an 'a'
 * or "bb" c. Each "bb" is followed by nothing or an 'a' If all the rules are
 * followed by the given string, return true otherwise return false.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= |S| <= 1000 where |S| represents length of string S. Sample Input 1 : abb
 * Sample Output 1 : true
 */
public class CheckAB {

	public static boolean checkAB(String input) {

		return helper_CheckAB(input, false, "");

	}

	public static boolean helper_CheckAB(String input, boolean status, String previous) {

		// Base Case:
		if (input.length() == 0) {
			return status;
		}

		// The string begins with an 'a'
		if ((input.charAt(0) == 'a') && (previous.isEmpty())) {
			status = true;
			String subStr = input.substring(1);
			/*System.out.println("The string begins with an 'a': " + input.charAt(0) + ", subStr: " + subStr
					+ " previous :" + previous);*/
			return helper_CheckAB(subStr, status, previous + input.charAt(0));
		}

		// Each 'a' is followed by nothing or an "bb"
		else if ((status) && (previous.charAt(previous.length() - 1) == 'a') && (input.charAt(0) == 'b')
				&& (input.charAt(1) == 'b')) {
			status = true;
			String subStr = input.substring(2);
			/*System.out.println("Each 'a' is followed by nothing or an \"bb\": " + input.charAt(0) + ", subStr: "
					+ subStr + " previous :" + previous);*/
			return helper_CheckAB(subStr, status, (previous + input.charAt(0) + input.charAt(1)));
		}

		// Each 'a' is followed by nothing or an 'a'
		else if ((status) && (previous.charAt(previous.length() - 1) == 'a') && (input.charAt(0) == 'a')) {
			status = true;
			String subStr = input.substring(1);
			/*System.out.println("Each 'a' is followed by nothing or an 'a': " + input.charAt(0) + ", subStr: " + subStr
					+ " previous :" + previous);*/
			return helper_CheckAB(subStr, status, (previous + input.charAt(0)));
		}

		// Each "bb" is followed by nothing or an 'a'
		else if ((status) && (previous.charAt(previous.length() - 1) == 'b')
				&& (previous.charAt(previous.length() - 2) == 'b') && (input.charAt(0) == 'a')) {
			status = true;
			String subStr = input.substring(1);
			/*System.out.println("Each 'bb' is followed by nothing or an 'a': " + input.charAt(0) + ", subStr: " + subStr
					+ " previous :" + previous);*/
			return helper_CheckAB(subStr, status, (previous + input.charAt(0)));
		} else {
			status = false;
			// String subStr = input.substring(1);
			return helper_CheckAB("", status, (previous + input.charAt(0)));
		}

	}

	public static void main(String[] args) {

		System.out.println(checkAB("abb"));
		System.out.println(checkAB("abbb"));
		System.out.println(helper_CheckAB("abc", false, ""));
		System.out.println(helper_CheckAB("abababa", false, ""));
		System.out.println(helper_CheckAB("abba", false, ""));
	}

}
