package com.recursion_L1;

/**
 * Given two integers M & N, calculate and return their multiplication using
 * recursion. You can only use subtraction and addition for your calculation. No
 * other operators are allowed.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 0
 * <= M <= 1000 0 <= N <= 1000 Sample Input 1 : 3 5 Sample Output 1 : 15 Sample
 * Input 2 : 4 0 Sample Output 2 : 0
 */
public class MultiplyTwoIntegers {

	public static int multiplyTwoIntegers(int m, int n) {

		if (m == 0) {
			return 0;
		}

		// Base Case:
		if (n == 0) {
			return 0;
		}

		int sum = m + multiplyTwoIntegers(m, n - 1);

		return sum;
	}

	public static void main(String[] args) {

		System.out.println(multiplyTwoIntegers(3, 5));
		System.out.println(multiplyTwoIntegers(3, 0));
		System.out.println(multiplyTwoIntegers(0, 0));
		System.out.println(multiplyTwoIntegers(0, 5));
	}

}
