package com.recursion_L1;

public class ReverseString {

	public static String reverseString(String str, int idx) {

		// Base Case:
		if (str.length() == idx) {
			return "";
		}

		String subStr = reverseString(str, idx + 1);

		return (subStr + str.charAt(idx));
	}

	public static void main(String[] args) {
		System.out.println(reverseString("abcdef", 0));
	}
}
