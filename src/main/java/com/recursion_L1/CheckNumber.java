package com.recursion_L1;

/**
 * Given an array of length N and an integer x, you need to find if x is present
 * in the array or not. Return true or false.
 * 
 * Do this recursively.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= N <= 10^3 Sample Input 1 : 3 9 8 10 8 Sample Output 1 : true Sample Input
 * 2 : 3 9 8 10 2 Sample Output 2 : false
 */

public class CheckNumber {

	public static boolean checkNumber(int input[], int x) {

		return subCheckNumber(input, x, 0);

	}

	public static boolean subCheckNumber(int input[], int x, int idx) {

		// Base Case::
		if (idx == input.length) {
			return false;
		}

		boolean state = subCheckNumber(input, x, idx + 1);

		if ((input[idx] == x) || (state == true)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6 };
		System.out.println(subCheckNumber(input, -4, 0));
	}

}
