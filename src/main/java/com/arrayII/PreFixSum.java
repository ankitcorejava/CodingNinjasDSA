package com.arrayII;

import java.util.Arrays;

/*
 For Array A of size n, the prefix sum of A is another array P of size n+1, 
 where P[i] represents the sum of the first i elements of A. That is,
P[0] = A[0]
P[1] = A[0] + A[1]
P[2] = A[0] + A[1] + A[2]
...
P[n-1] = A[0] + A[1] + ... + A[n-1]
You will given an array arr of length n along with an output array of the same length. 
Your objective is to populate the output array as required, without the need to print or return anything.
 */
public class PreFixSum {

	public static void prefixSum(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			arr[i] = arr[i-1]+arr[i];
		}
		
		Arrays.stream(arr).boxed().forEach(z -> System.out.print(z+" "));
	}

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5 };
		// int[] output = new int[4];
		PreFixSum.prefixSum(a);

	}

}
