package com.arrayII;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray2 {

	public static void rotate(int[] arr, int d) {
		
		if(arr.length ==0 ) {
			return;
		}
		
		int n = arr.length;
		d = d % n; // Adjust rotation if d > n

		// Reverse the first d elements
		reverse(arr, 0, d - 1);

		// Reverse the remaining elements
		reverse(arr, d, n - 1);

		// Reverse the entire array
		reverse(arr, 0, n - 1);
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	/*
	 * public static void main(String[] args) { // Example usage: /* int[] arr = {1,
	 * 2, 3, 4, 5, 6, 7}; int d = 2; rotateLeft(arr, d);
	 * 
	 * // Print the rotated array for (int num : arr) { System.out.print(num + " ");
	 * }
	 * 
	 * int[] arr1 = {0}; int d1= 0; rotateLeft(arr1, d1);
	 * 
	 * // Print the rotated array for (int num : arr1) { System.out.print(num +
	 * " "); }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		Scanner sr = new Scanner(System.in);
		int t = sr.nextInt();
		while (t > 0) {
			int n = sr.nextInt();
			int ar[] = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = sr.nextInt();
			}
			int d = sr.nextInt();
			RotateArray2.rotate(ar, d);
			for (int i = 0; i < n; i++) {
				System.out.print(ar[i] + " ");
			}
			System.out.println();
			t = t - 1;
		}
	}

}
