package com.string;

import java.util.Stack;

public class CompressedString {

	public static String getCompressedString(String str) {

		Stack<Character> stck = new Stack<Character>();
		StringBuilder strBuilder = new StringBuilder();
		int iCnt = 0;

		for (int i = 0; i < str.length(); i++) {

			// If stack is empty?
			if (stck.isEmpty()) {
				stck.push(str.charAt(i));
				continue;
			}

			// get the top and check if Top != current?
			char top = stck.peek();
			if (top != str.charAt(i)) {

				while (stck.size() > 0) {
					stck.pop();
					iCnt++;
				}
				strBuilder.append(top + "" + iCnt);
				iCnt = 0;
				stck.push(str.charAt(i));
				continue;
			}

			if (top == str.charAt(i)) {
				stck.push(str.charAt(i));
				continue;
			}
		}

		if (stck.size() > 0) {
			char top = stck.peek();
			while (stck.size() > 0) {
				stck.pop();
				iCnt++;
			}
			strBuilder.append(top + "" + iCnt);

		}
		return strBuilder.toString().replaceAll("1","");

	}

	public static void main(String[] args) {

		System.out.println(CompressedString.getCompressedString("aaabbcddeeeee"));

	}

}
