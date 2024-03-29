package com.recursion_L2;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an input string S and two characters c1 and c2, you need to replace
 * every occurrence of character c1 with character c2 in the given string.
 * 
 * Do this recursively.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= Length of String S <= 10^6
 * 
 * Sample Input : abacd a x Sample Output : xbxcd
 */
public class RemoveCharacter {

	public static String removeX(String input) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */

		char[] outPut = helper_removeCharacter(input.toCharArray(), 'x', 0);

		Function<String, String> funs = x -> x;
		return Stream.of(new String(outPut)).map(funs).collect(Collectors.joining(" ")).replaceAll("-","");

	}

	public static char[] helper_removeCharacter(char[] input, char c1, int idx) {

		// Base Case::
		if (idx == input.length) {
			return new char[0];
		}

		helper_removeCharacter(input, c1, idx + 1);
		if (input[idx] == c1) {
			input[idx] = '-';
		}

		return input;
	}

	public static void main(String[] args) {

		System.out.println(removeX("abaxcdx"));
	}

}
