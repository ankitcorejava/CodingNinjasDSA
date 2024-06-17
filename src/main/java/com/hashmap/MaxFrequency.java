package com.hashmap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MaxFrequency {

	public static void main(String[] args) {
		int[] input = { 7,4, 2, 2,2, 4, 8, 4 };
		maxFrequencyNumber(input);
	}

	public static int maxFrequencyNumber(int[] arr) {

		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */

		// HashSet<Integer> sets = new LinkedHashSet<Integer>();

		Supplier<LinkedHashMap<Integer, Long>> sup = () -> new LinkedHashMap<>();

		Map<Integer, Long> map = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), sup, Collectors.counting()));

		// {2=2, 4=2, 7=1, 8=1}

		//System.out.println(map);

		Comparator<Entry<Integer, Long>> comp = (a, b) -> a.getValue().compareTo(b.getValue());
		Integer map2 =  map.entrySet().stream().max(comp).get().getKey();
		
		//System.out.println(map2);

		return map2;
	}

}
