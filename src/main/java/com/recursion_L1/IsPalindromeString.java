package com.recursion_L1;

/**
 * 
 * Problem statement Determine if a given string ‘S’ is a palindrome using
 * recursion. Return a Boolean value of true if it is a palindrome and false if
 * it is not.
 * 
 * Note: You are not required to print anything, just implement the function.
 * Example: Input: s = "racecar" Output: true Explanation: "racecar" is a
 * palindrome. Detailed explanation ( Input/output format, Notes, Images )
 * Sample Input 1: abbba Sample Output 1: true Explanation Of Sample Input 1 :
 * “abbba” is a palindrome Sample Input 2: abcd Sample Output 2: false
 * Explanation Of Sample Input 2 : “abcd” is not a palindrome. Constraints: 0 <=
 * |S| <= 10^6 where |S| represents the length of string S.
 * 
 * String aba =
 * 
 * 
 */
public class IsPalindromeString {

	public static boolean isPalindrome(String str) {

		return (subIsPalindrome(str, 0, (str.length() - 1)));

	}

	public static boolean subIsPalindrome(String str, int strIdx, int endIdx) {

		if ((strIdx == str.length()) || (endIdx < 0)) {
			return true;
		}

		boolean currentState = subIsPalindrome(str, strIdx + 1, endIdx - 1);
		if ((str.charAt(strIdx) == str.charAt(endIdx)) && (currentState)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		// int[] input = { 3, 12, 34, 2, 0, -1 };
		System.out.println(subIsPalindrome("aba", 0, "aba".length() - 1));
	}

}
