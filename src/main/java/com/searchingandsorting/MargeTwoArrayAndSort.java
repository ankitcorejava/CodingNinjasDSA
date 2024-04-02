package com.searchingandsorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MargeTwoArrayAndSort {

	public static List<Integer> margeTwoArrayAndSort(int[] arr1, int n, int[] arr2, int m) {

		int[] arr1And2 = new int[n + m];

		Arrays.sort(arr1);

		System.arraycopy(arr1, 0, arr1And2, 0, n);
		System.arraycopy(arr2, 0, arr1And2, n, m);

		List<Integer> list = Arrays.stream(arr1And2).boxed().sorted(Collections.reverseOrder().reversed())
				.collect(Collectors.toList());

		return list;

	}

	public static void main(String[] args) {

		int N = 3;
		int arr1[] = { 10, 20, 30 };
		int M = 2;
		int arr2[] = { 17, 15 };
		margeTwoArrayAndSort(arr1, N, arr2, M);
	}

}
