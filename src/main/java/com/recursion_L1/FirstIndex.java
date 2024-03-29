package com.recursion_L1;

/**
 * Given an array of length N and an integer x, you need to find and return the
 * first index of integer x present in the array. Return -1 if it is not present
 * in the array.
 * 
 * First index means, the index of first occurrence of x in the input array.
 * 
 * Do this recursively. Indexing in the array starts from 0.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= N <= 10^3
 * 
 * Sample Input : 4 9 8 10 8 8 Sample Output : 1
 */
public class FirstIndex {

	public static int firstIndex(int input[], int x) {
		return subFirstIndex(input, x, 0);
	}

	public static int subFirstIndex(int input[], int x, int idx) {

		// Base Case:
		if (idx == input.length) {
			return -1;
		}

		if (input[idx] == x) {
			return idx;
		}
		int idxa = subFirstIndex(input, x, idx + 1);

		return idxa;

	}

	public static void main(String[] args) {

		int[] A0 = { -8, 9, 8, 10, 8 };
		System.out.println(subFirstIndex(A0, 8, 0));
	}

}
