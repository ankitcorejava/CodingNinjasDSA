package com.stack;

import java.util.Stack;

/**
 * For a given a string expression containing only round brackets or
 * parentheses, check if they are balanced or not. Brackets are said to be
 * balanced if the bracket which opens last, closes first.
 * 
 * Example: Expression: (()()) Since all the opening brackets have their
 * corresponding closing brackets, we say it is balanced and hence the output
 * will be, 'true'. You need to return a boolean value indicating whether the
 * expression is balanced or not.
 * 
 * Note: The input expression will not contain spaces in between.
 */
public class BalancedBrackets {

	public static boolean isBalanced(String expression) {

		if (expression == null) {
			return false;
		}
		if (expression.length() < 2) {
			return false;
		}

		char[] express = expression.toCharArray();
		Stack<Character> stk = new Stack<Character>();

		for (int i = 0; i < express.length; i++) {

			if (express[i] == '(') {
				stk.push(express[i]);
			} else if (express[i] == ')') {
				if (stk.isEmpty()) {
					return false;
				}
				char pop = stk.pop();
				if (pop != '(') {
					return false;
				}
			}

		}

		return stk.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("(()()) :" + BalancedBrackets.isBalanced("(()())"));

		System.out.println("(()() :" + BalancedBrackets.isBalanced("(()()"));

		System.out.println("(()()()) :" + BalancedBrackets.isBalanced("(()()())"));

		System.out.println("()()(() :" + BalancedBrackets.isBalanced("()()(()"));
		
		System.out.println( ")()()( :" + BalancedBrackets.isBalanced(")()()("));
	}

}
