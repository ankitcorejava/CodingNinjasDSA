package com.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * ou have been given two stacks that can store integers as the data. Out of the
 * two given stacks, one is populated and the other one is empty. You are
 * required to write a function that reverses the populated stack using the one
 * which is empty.
 * 
 * For Example: Alt txt
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints: 1 <=
 * N <= 10^3 -2^31 <= data <= 2^31 - 1
 * 
 * Time Limit: 1sec Sample Input 1: 6 1 2 3 4 5 10 Note: Here, 10 is at the top
 * of the stack. Sample Output 1: 1 2 3 4 5 10 Note: Here, 1 is at the top of
 * the stack. Sample Input 2: 5 2 8 15 1 10 Sample Output 2: 2 8 15 1 10
 */
public class ReverseStack {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
	 
		System.out.println(input.peek()); 
		
		
		while (!input.isEmpty()) {
			extra.push(input.pop());
		}

		while (!extra.isEmpty()) {
			System.out.println(extra.pop());
		}

	}

	public static void main(String[] args) {

		Stack<Integer> stk = new Stack<Integer>();
		stk.push(1);
		stk.push(2);
		stk.push(3);

		ReverseStack.reverseStack(stk, new Stack<Integer>());

	}
}
