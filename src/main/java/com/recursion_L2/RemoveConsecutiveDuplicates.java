package com.recursion_L2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveConsecutiveDuplicates {

	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
		char[] outPut = helper_removeConsecutiveDuplicates(s.toCharArray(), 0);
		String strs = new String(outPut);
		return Stream.of(strs).collect(Collectors.joining(" ")).replaceAll("-","");

	}

	public static char[] helper_removeConsecutiveDuplicates(char[] charInput, int idx) {

		// Base Case:::
		if (charInput.length == idx) {
			return new char[0];
		}

		helper_removeConsecutiveDuplicates(charInput, idx + 1);

		if ((idx > 0) && (charInput[idx] == charInput[idx - 1])) {
			charInput[idx] = '-';
		}

		return charInput;
	}

	public static void main(String[] args) {

		System.out.println(removeConsecutiveDuplicates("xxxyyyzwwzzz"));
	}

}
