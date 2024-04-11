package com.arrayII;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Problem statement You have been given an integer array/list(ARR) of size N
 * which contains numbers from 0 to (N - 2). Each number is present at least
 * once. That is, if N = 5, the array/list constitutes values ranging from 0 to
 * 3, and among these, there is a single integer value that is present twice.
 * You need to find and return that duplicate number present in the array.
 * 
 * Note : Duplicate number is always present in the given array/list. Detailed
 * explanation ( Input/output format, Notes, Images ) Constraints : 1 <= t <=
 * 10^2 0 <= N <= 10^6
 * 
 * Time Limit: 1 sec Sample Input 1: 1 9 0 7 2 5 4 7 1 3 6 Sample Output 1: 7
 */
public class FindUnique {

	public static int findUnique(int[] arr) {

		if (arr.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(arr[0], 1);

		for (int i = 1; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				map.put(arr[i], (map.get(arr[i]) + 1));
			} else {
				map.put(arr[i], 1);
			}

		}

		Predicate<Entry<Integer, Integer>> pred = x -> x.getValue() == 1;
		//System.out.println(map.entrySet().stream().filter(pred).collect(Collectors.toList()).get(0).getKey());
		return (map.entrySet().stream().filter(pred).collect(Collectors.toList()).get(0).getKey());
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 6, 3,6 ,2};
		findUnique(a);

	}
}
