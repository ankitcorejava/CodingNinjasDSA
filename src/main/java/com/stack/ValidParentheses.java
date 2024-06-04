package com.stack;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Every close bracket has a corresponding open
 * bracket of the same type.
 */
public class ValidParentheses {

	public static void main(String[] args) {

		System.out.println("[{}(){] " + validParentheses("[{}(){]"));
		System.out.println("[{}()] " + validParentheses("[{}()]"));
		System.out.println("() " + validParentheses("()"));
		System.out.println("()()" + validParentheses("()()"));
		System.out.println("()(())" + validParentheses("()(())"));
	}

	private static boolean validParentheses(String str) {

		Stack<Character> stk = new Stack<Character>();

		
		for (int i = 0; i < str.length(); i++) {
		
			if (stk.isEmpty()) {

				if (str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')') {

					return false;
				}
				else {
					stk.add(str.charAt(i));
				}

			} else {
				char top_ch = stk.peek();
				if ((top_ch == '[') && (str.charAt(i) == ']')) {
					stk.pop();
				}			

				else if ((top_ch == '{') && (str.charAt(i) == '}')) {
					stk.pop();
				}			

				else if ((top_ch == '(') && (str.charAt(i) == ')')) {
					stk.pop();
				}
				else {
					stk.add(str.charAt(i));
				}

			}

		}

		return stk.isEmpty();

	}

}
