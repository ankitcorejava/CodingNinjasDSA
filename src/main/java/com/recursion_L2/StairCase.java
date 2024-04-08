package com.recursion_L2;

import java.util.ArrayList;
import java.util.List;

/**
 * A child is running up a staircase with N steps, and can hop either 1 step, 2
 * steps or 3 steps at a time. Implement a method to count how many possible
 * ways the child can run up to the stairs. You need to return number of
 * possible ways W.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= N <= 30 Sample Input 1 : 4 Sample Output 1 : 7 Sample Input 2 : 5 Sample
 * Output 2 : 13
 */
public class StairCase {

	public static int staircase(int n) {

		/*
		 * Your class should be named Solution. Don't write main() function. Don't read
		 * input, it is passed as function argument. Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */

		List<String> iCnt = new ArrayList<>();
		helper_staircase(n, "", iCnt);
		return iCnt.size();

	}

	public static void helper_staircase(int n, String ansSofar, List<String> iCnt) {

		// Base Case::
		if (n == 0) {
			// System.out.println(ansSofar);
			iCnt.add(ansSofar);
			return;
		}

		// Step:1;
		if (n >= 1) {
			helper_staircase(n - 1, ansSofar + "1", iCnt);
		}

		// Step:2;
		if (n >= 2) {
			helper_staircase(n - 2, ansSofar + "2", iCnt);
		}

		// Step:3;
		if (n >= 3) {
			helper_staircase(n - 3, ansSofar + "3", iCnt);
		}

	}

	public static void main(String[] args) {

		System.out.println(staircase(4));
	}
}
