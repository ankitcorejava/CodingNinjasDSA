package com.searchingandsorting;

/**
 * You have been given two sorted arrays/lists(ARR1 and ARR2) of size N and M
 * respectively, merge them into a third array/list such that the third array is
 * also sorted.
 * 
 * Note: Sample Input1 = 1 3 4 7 11 ; Input2 = 2 4 6 13 ; Sample Output 1 : 1 2
 * 3 4 4 6 7 11 13
 */
public class MergeTwoSortedArray {

	public static int[] merge(int arr1[], int arr2[]) {

		int left = 0;
		int right = 0;
		int n = arr1.length;
		int m = arr2.length;

		int out[] = new int[n + m];
		int idx = 0;

		while ((left < n) && (right < m)) {

			if (arr1[left] < arr2[right]) {
				out[idx] = arr1[left];
				idx++;
				left++;

			} else if (arr2[right] < arr1[left]) {
				out[idx] = arr2[right];
				idx++;
				right++;
			} else {
				out[idx] = arr1[left];
				idx++;
				out[idx] = arr2[right];
				idx++;
				right++;
				left++;

			}

		}

		// if either of arrays are over then either of them will have few element left
		// and needs to be added.

		while (left < n) {
			out[idx] = arr1[left];
			idx++;
			left++;
		}

		while (right < m) {
			out[idx] = arr2[right];
			idx++;
			right++;
		}
		return out;
	}

	public static void main(String[] args) {

		int[] arr1 = { 1, 3, 4, 7, 11 };
		int[] arr2 = { 2, 4, 6, 13 };

		merge(arr1, arr2);
	}

}
