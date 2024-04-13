package com.searchingandsorting;

/**
 * You are given the starting 'l' and the ending 'r' positions of the array
 * 'ARR'. You must sort the elements between 'l' and 'r'. Note: Change in the
 * input array itself. So no need to return or print anything. Example: Input:
 * ‘N’ = 7, 'ARR' = [2, 13, 4, 1, 3, 6, 28]
 * 
 * Output: [1 2 3 4 6 13 28] Explanation: After applying 'merge sort' on the
 * input array, the output is [1 2 3 4 6 13 28].
 */
public class MergeSort {

	public static void mergeSort(int[] arr, int l, int r) {

		// Base Case:::
		if (l == r) {

			return;
		}

		int mid = ((l + r) / 2);

		mergeSort(arr, l, mid); 
		mergeSort(arr, (mid + 1), r);
		merge(arr, l, mid, r);

	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		// Copy data to temp arrays L[] and R[]
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[mid + 1 + j];

		// Merge the temp arrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] input = { 2, 13, 4, 1, 3, 6, 28 };

		mergeSort(input, 0, input.length - 1);

		// Print the sorted array
		for (int num : input) {
			System.out.print(num + " ");
		}
	}
}
