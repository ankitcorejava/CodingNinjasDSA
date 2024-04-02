package com.searchingandsorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two unsorted arrays of non-negative integers, 'arr1' and 'arr2' of size
 * 'N' and 'M', respectively. Your task is to find the pair of elements (one
 * from each array), such that their absolute (non-negative) difference is the
 * smallest, and return the min difference.
 * 
 * Example : N = 3, arr1 = [10, 20, 30] M = 2, arr2 = [17, 15] The smallest
 * difference pair is (20, 17) with an absolute difference of 3. So, the answer
 * is 3.
 */
public class SmallestDifferencePair {

	public static int smallestDifferencePair(int[] arr1, int n, int[] arr2, int m) {

		if (arr1.length == 0 || arr2.length == 0) {
			return -1;
		}

		int fdiff = Integer.MAX_VALUE;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				int diff = Math.abs(arr1[i] - arr2[j]);
				if (fdiff > diff) {
					fdiff = diff;
				}
			}
		}
		return fdiff;
	}

	public static void main(String[] args) {

		int N = 3;
		int arr1[] = { 10, 20, 30 };
		int M = 2;
		int arr2[] = { 17, 15 };
		System.out.println(smallestDifferencePair(arr1, N, arr2, M));
	}

}
