package com.recursion_L2;

/**
 * Given an integer N, count and return the number of zeros that are present in
 * the given integer using recursion.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 0
 * <= N <= 10^9 Sample Input 1 : 0 Sample Output 1 : 1 Sample Input 2 : 00010204
 * Sample Output 2 : 2 Explanation for Sample Output 2 : Even though "00010204"
 * has 5 zeros, the output would still be 2 because when you convert it to an
 * integer, it becomes 10204. Sample Input 3 : 708000 Sample Output 3 : 4
 */
public class CountZerosRec {

	public static int countZerosRec(int input) {
		// Write your code here

		// Base Case::
		if (input == 0) {
			System.out.println("input Base :" + input);
			return 1;
		}

		// Base Case::
		if (input > 0 && input <10 ) {
			System.out.println("input Base :" + input);
			return 0;
		}

		int sub_sum = countZerosRec((input / 10));
		System.out.println("input:" + input + " ; (input % 10) " + (input % 10));
		if ((input % 10) == 0) {
			sub_sum = sub_sum + 1;
		}
		System.out.println("sub_sum:" + sub_sum);
		return sub_sum;

	}

	public static void main(String[] args) {
		System.out.println(countZerosRec(30452032));
	}
}
