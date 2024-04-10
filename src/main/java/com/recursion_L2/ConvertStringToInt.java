package com.recursion_L2;

/**
 * Write a recursive function to convert a given string into the number it
 * represents. That is input will be a numeric string that contains only
 * numbers, you need to convert the string into corresponding integer and return
 * the answer.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 0 <
 * |S| <= 9 where |S| represents length of string S. Sample Input 1 : 00001231
 * Sample Output 1 : 1231
 */
public class ConvertStringToInt {

	public static int convertStringToInt(String input) {

		return helper_convertStringToInt(input, input.length() - 1);

	}

	public static int helper_convertStringToInt(String input, int len) {

		// Base Case:
		if (input.length() == 0) {
			return 0;
		}

		char Ist = input.charAt(0);
		String subStr = input.substring(1);
		int IstValue = Integer.parseInt(String.valueOf(Ist));

		int sum = 0;
		if (len == 0) {
			sum = IstValue;
		} else {
			sum = (Math.multiplyExact((int) (Math.pow(10, len)), IstValue));
		}

		//System.out.println(sum);
		return (sum + helper_convertStringToInt(subStr, subStr.length() - 1));

	}

	public static void main(String[] args) {

		String arr = "125678";
		System.out.println(convertStringToInt(arr));
	}

}
