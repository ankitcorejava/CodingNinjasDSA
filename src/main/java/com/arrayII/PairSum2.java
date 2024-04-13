package com.arrayII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * You have been given an integer array/list(ARR) and a number 'num'. Find and
 * return the total number of pairs in the array/list which sum to 'num'.
 * 
 * Note: Given array/list can contain duplicate elements. Detailed explanation (
 * Input/output format, Notes, Images ) Constraints : 1 <= t <= 10^2 0 <= N <=
 * 10^4 0 <= num <= 10^9
 * 
 * Time Limit: 1 sec Sample Input 1: 1 9 1 3 6 2 5 4 3 2 4 7 Sample Output 1: 7
 */
public class PairSum2 {

	public static int pairSum(int[] arr, int num) {

		Set<List<Integer>> listAns = new HashSet<>();

		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

		Map<Integer, Integer> elementToIndex = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {

			int searchInput = num - (list.get(i));
			if (elementToIndex.containsKey(searchInput)) {

				List<Integer> ans = new ArrayList<>();
				ans.add(i);
				ans.add(elementToIndex.get(searchInput));
				Collections.sort(ans);
				listAns.add(ans);
				// list.remove((Object) searchInput);

			}
			elementToIndex.put(arr[i], i);
		}

		return listAns.size();

	}

	public static void main(String[] args) {
		/*
		 * int[] a = { 2, 8, 10, 5, -2, 5 }; int target = 10;
		 * System.out.println(pairSum(a, target));
		 * 
		 * int[] a1 = { 0,6,0,0 }; int target1 = 6; System.out.println(pairSum(a1,
		 * target1));
		 */

		int[] a2 = { 3, 3, 3, 3, 3 };
		int target2 = 6;
		System.out.println(pairSum(a2, target2));
	}
}
