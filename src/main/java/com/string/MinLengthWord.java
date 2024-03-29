package com.string;

import java.util.Stack;

/*
	 * Given a string S (that can contain multiple words), you need to find the word which has minimum length.
	
	Note : If multiple words are of same length, then answer will be first minimum length word in the string. Words are seperated by single space only.
	Detailed explanation ( Input/output format, Notes, Images )
	Constraints :
	1 <= Length of String S <= 10^5
	
	Sample Input 1 :
	this is test string
	Sample Output 1 :
	is
	Sample Input 2 :
	abc de ghihjk a uvw h j
	Sample Output 2 :
	a
 */
public class MinLengthWord {

	public static String minLengthWord(String input) {

		if (input == null) {
			return null;
		}

		String outPut = null;

		if (input.length() > 0) {

			String[] strArr = input.split(" ");

			Stack<String> stk = new Stack<String>();

			for (int i = 0; i < strArr.length; i++) {

				if (stk.isEmpty()) {
					stk.push(strArr[i]);
				} else if (stk.peek().length() > strArr[i].length()) {

					stk.pop();
					stk.push(strArr[i]);
				} else if (stk.peek().length() < strArr[i].length()) {

					continue; // No Action.
				}

			}

			outPut = stk.peek();

		} else {
			outPut = "";
		}

		return outPut;
	}

	public static void main(String[] args) {

		System.out.println(minLengthWord("abc de ghihjk a uvw h j"));
	}

}
