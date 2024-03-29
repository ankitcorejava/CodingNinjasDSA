package com.string;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class CheckPermutations {

	public static boolean isPermutation(String str1, String str2) {

		if (str1 == null || str2 == null) {
			return false;
		}

		if (str1.length() != str2.length()) {
			return false;
		}

		IntFunction<Character> ints = x -> (char) x;
		List<Character> l1 = str1.chars().sorted().mapToObj(ints).collect(Collectors.toList());
		List<Character> l2 = str2.chars().sorted().mapToObj(ints).collect(Collectors.toList());


		for (int i = 0; i < l1.size(); i++) {

			if (l1.get(i) != l2.get(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		/*
		 * System.out.println(isPermutation("listee", "sileet"));
		 * System.out.println(isPermutation("listeee", "sileet"));
		 */

		System.out.println(isPermutation("phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjpre",
				"pggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf"));

		System.out.println(isPermutation("", ""));

	}

}
