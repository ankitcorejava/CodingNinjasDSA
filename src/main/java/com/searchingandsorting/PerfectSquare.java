package com.searchingandsorting;

/**
 * You are given a positive integer ‘N’. Your task is to find and return its
 * square root. If ‘N’ is not a perfect square, then return the floor value of
 * sqrt(N).
 * 
 * Example: Input: ‘N’ = 6
 * 
 * Output: 2
 * 
 * Explanation: The square root of the number 6 lies between 2 and 3, so the
 * floor value is 2.
 */
public class PerfectSquare {
	
	public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */

		return  (int) Math.sqrt(N);
	}
	
	public static void main(String[] args) {
		System.out.println(sqrtN(6L));
	}

}
