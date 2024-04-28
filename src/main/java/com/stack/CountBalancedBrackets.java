package com.stack;

import java.util.Stack;

public class CountBalancedBrackets {

	public static int countBalancedBrackets(String str) {

		// {{}}}}}}}}}{{{{{{{;
		int iCnt = 0;
		Stack<Character> stk = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '{') {
				stk.push(str.charAt(i));
			} else if ((!stk.isEmpty()) && (str.charAt(i) == '}')) {
				if (stk.peek() == '{') {
					stk.pop();
					iCnt++;
				}
			}

		}

		return iCnt;

	}

	public static void main(String[] args) {
		System.out
				.println("{{}}}}}}}}}{{{{{{{} : " + CountBalancedBrackets.countBalancedBrackets("{{}}}}}}}}}{{{{{{{}"));

		System.out.println("{{}}}}}}}}}{{{{{{{ : " + CountBalancedBrackets.countBalancedBrackets("{{}}}}}}}}}{{{{{{{"));

		System.out.println("{{}}} : " + CountBalancedBrackets.countBalancedBrackets("{{}}}"));
		
		System.out.println("}{ : " + CountBalancedBrackets.countBalancedBrackets("}{"));
	}

}
