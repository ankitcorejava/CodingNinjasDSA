package com.hashmap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M,
 * respectively. You need to print their intersection; An intersection for this
 * problem can be defined when both the arrays/lists contain a particular value
 * or to put it in other words, when there is a common value that exists in both
 * the arrays/lists.
 * 
 * Note : Input arrays/lists can contain duplicate elements.
 * 
 * The intersection elements printed would be in the order they appear in the
 * second array/list (ARR2).
 */
public class PrintInterSection {


	public static void main(String[] args) {
		

		int[] arr1 = { 2, 6, 8, 5, 4, 3 };
		int[] arr2 = { 2, 3, 4, 7 };

		printIntersection(arr1, arr2);
	}



	public static void printIntersection(int[] arr1, int[] arr2) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */

		Map<Integer, Long> map1 = Arrays.stream(arr1).boxed()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		Map<Integer, Long> map2 = Arrays.stream(arr2).boxed()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		Iterator<Entry<Integer, Long>> itr = map2.entrySet().iterator();

		while (itr.hasNext()) {

			Entry<Integer, Long> entry = itr.next();
			if (map1.containsKey(entry.getKey())) {

				for (int i = 0; i < map1.get(entry.getKey()); i++) {
					System.out.println(entry.getKey());
				}
			}
		}

	}

}
