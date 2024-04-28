package com.stack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * For a given expression in the form of a string, find the minimum number of
 * brackets that can be reversed in order to make the expression balanced. The
 * expression will only contain curly brackets.
 * 
 * If the expression can't be balanced, return -1.
 * 
 * Example: Expression: {{{{ If we reverse the second and the fourth opening
 * brackets, the whole expression will get balanced. Since we have to reverse
 * two brackets to make the expression balanced, the expected output will be 2.
 * 
 * Expression: {{{ In this example, even if we reverse the last opening bracket,
 * we would be left with the first opening bracket and hence will not be able to
 * make the expression balanced and the output will be -1.
 */
public class CountBracketReversals {

	public static int countBracketReversals(String input) {

		if (input.length() % 2 != 0) { // If the length of the expression is odd, it can't be balanced
			return -1;
		}

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '{') {
				stack.push(input.charAt(i));
			} else if ((!stack.isEmpty()) && ('}' == input.charAt(i))) {
				stack.pop();
			} else if (stack.isEmpty() && ('}' == input.charAt(i))) {
				stack.push(input.charAt(i));
			}
		}

		if (!stack.isEmpty()) {
			if (stack.size() % 2 == 0 && (stack.get(0) == '}')) {
				return (stack.size());
			}

			else if (stack.size() % 2 == 0) {
				return (stack.size() / 2);
			} else {
				return -1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		System.out.println("{{{ : " + countBracketReversals("{{{"));

		System.out.println("{{{{}} : " + countBracketReversals("{{{{}}"));

		System.out.println("{{{{ : " + countBracketReversals("{{{{"));

		System.out.println("}}}{{{ : " + countBracketReversals("}}}{{{"));

		System.out.println(countBracketReversals("{{}}{}}}}}{{{{{{{}{}{}}{}}{}}{{}{}{}{{{}{{}{{}{{{}{}}{{{{{{}}{}}}}}}}}}{}{}}}{{}{{}}}}}}{}}{}{{}}}{{"));
	}

}
