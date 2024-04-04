package com.arrayII;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class BalanceArray {

	public static boolean isBalanceArray(int[] input) {

		boolean balanceState = false;

		/**
		 * Looping over input array and adding keys as array value and maintaining it
		 * frequency in values;
		 */
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length; i++) {

			if (map.isEmpty()) {
				map.put(input[i], 1);
			}

			else if (map.containsKey(input[i])) {
				map.put(input[i], map.get(input[i]) + 1);
			} else {
				map.put(input[i], 1);
			}

		}

		/** Iterating over map **/
		Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Integer, Integer> i = itr.next();
			int key = i.getKey();
			int value = i.getValue();
			int searchableKey = key < 0 ? (Math.abs(key)) : (-key); /*
																	 * Either of values +Ve or -Ve can come 1st making
																	 * my searchable key based on its abs values;
																	 */
			if (key != 0) { /* Eliminating '0' as it lies between +ve & -Ve Integer; */
				if (map.containsKey(searchableKey)) {
					/**
					 * These two if can be merged but for better understanding i kept it apart.
					 **/
					if (value == map.get(searchableKey)) {
						balanceState = true;
					} else {
						balanceState = false;
					}
				} else {
					balanceState = false;
				}

			}
		}
		return balanceState;
	}

	public static void main(String[] args) {

		int[] input = { 1, 2, 3, -2, -1, -3 };
		System.out.println(isBalanceArray(input));

		int[] input2 = { 1, 2, 3, -2, -1, -3, -3 };
		System.out.println(isBalanceArray(input2));

		int[] input3 = { 1, 2, 3, -2, -1, -3, 0 };
		System.out.println(isBalanceArray(input3));

	}

}
