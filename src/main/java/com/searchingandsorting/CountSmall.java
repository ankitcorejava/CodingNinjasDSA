package com.searchingandsorting;

import java.util.Arrays;

/**
 * You are given two arrays of integers. Let's call the first array A and the
 * second array B. A finds the number of elements in array B that are smaller
 * than or equal to that element for every array element. Constraints : 1 <= T
 * <= 10 1 <= N,M <= 10000 -1e9 <= A[i], B[i] <= 1e9 Time Limit: 1 sec Example:
 * Input: A = [0, 2, 3] B = [1, 5] Output: [0,1,1]
 */
public class CountSmall {

	public static int[] countS(int n, int m, int[] a, int[] b) {

		Arrays.sort(a);
		Arrays.sort(b);
		int out[] = new int[(n > m ? n : m)];
		int idx = 0;

		for (int i = 0; i < a.length; i++) {
			// boolean foundInII = false;
			int iCnt = 0;
			for (int j = 0; j < b.length; j++) {
				// System.out.println("b[j] <= a[i] = " + b[j] + " <= " + a[i]);
				if (b[j] <= a[i]) {
					iCnt++;
				} else if (b[j] > a[i]) {
					break;
				}
			}
			out[idx] = iCnt;
			idx++;

		}

		return out;

	}

	public static void main(String[] args) {

		int N = 2;
		int arr1[] = { 2, 4 };
		int M = 3;
		int arr2[] = { 1, 3, 5 };
		countS(N, M, arr1, arr2);
	}

}
