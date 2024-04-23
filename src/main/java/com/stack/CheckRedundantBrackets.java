package com.stack;

import java.util.Stack;
import java.util.regex.Matcher;

/**
 * Problem statement For a given expression in the form of a string, find if
 * there exist any redundant brackets or not. It is given that the expression
 * contains only rounded brackets or parenthesis and the input expression will
 * always be balanced.
 * 
 * A pair of the bracket is said to be redundant when a sub-expression is
 * surrounded by unnecessary or needless brackets.
 * 
 * Example: Expression: (a+b)+c Since there are no needless brackets, hence, the
 * output must be 'false'.
 * 
 * Expression: ((a+b)) The expression can be reduced to (a+b). Hence the
 * expression has redundant brackets and the output will be 'true'.
 */
public class CheckRedundantBrackets {

	public static boolean checkRedundantBrackets(String expression) {
		int iCnt = 0;
		Stack<Character> stk = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {

			if (!stk.isEmpty()) {
				iCnt = 0;
			}
			if (expression.charAt(i) == '(') {

				// Start pushing into stack
				while ((i < expression.length()) && (expression.charAt(i) != ')')) {
					stk.push(expression.charAt(i));
					i++;
				}
			}
			while (!stk.isEmpty() && stk.peek() != '(') {
				stk.pop();
				iCnt++;
			}
			if (!stk.isEmpty() && stk.peek() == '(') {
				stk.pop();
			}

			if (iCnt <= 1) {
				return true;
			}
		}

		return (iCnt > 1 ? false : true);

	}
	
	public static void main(String[] args) {
		
	 System.out.println(CheckRedundantBrackets.checkRedundantBrackets("(a+b)+c"));
	 
	 System.out.println(CheckRedundantBrackets.checkRedundantBrackets("((a+b))"));
	}
}
