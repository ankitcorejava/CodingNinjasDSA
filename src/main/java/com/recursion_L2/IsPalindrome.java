package com.recursion_L2;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Determine if a given string ‘S’ is a palindrome using recursion. Return a
 * Boolean value of true if it is a palindrome and false if it is not.
 * 
 * Note: You are not required to print anything, just implement the function.
 * Example: Input: s = "racecar" Output: true Explanation: "racecar" is a
 * palindrome.
 */
public class IsPalindrome {

	public static boolean isPalindrome(String str) {

		Function<String,String> fun = x -> new StringBuffer(x).reverse().toString();
		 String str2 = Stream.of(str).map(fun).collect(Collectors.joining(" "));

		return str2.equals(str);

	}
	
	public static void main(String[] str) {
		System.out.println( isPalindrome("abbb"));
		
	}

}
