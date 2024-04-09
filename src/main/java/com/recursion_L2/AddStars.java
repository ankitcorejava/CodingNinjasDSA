package com.recursion_L2;

/**
 * Given a string S, compute recursively a new string where identical chars that
 * are adjacent in the original string are separated from each other by a "*".
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 0
 * <= |S| <= 1000 where |S| represents length of string S. Sample Input 1 :
 * hello Sample Output 1: hel*lo Sample Input 2 : aaaa Sample Output 2 : a*a*a*a
 */
public class AddStars {

	public static String addStars(String s) {
		// Write your code here
		StringBuffer ans = new StringBuffer();
		helper_addStars(s, ans);

		return ans.toString();

	}

	public static void helper_addStars(String s, StringBuffer ans) {

		if (s == null) {
			return;
		}

		if (s.length() == 0) {
			//System.out.println(ans);
			return;
		}

		char IstChar = s.charAt(0);
		String subStr = s.substring(1);

		if (ans.isEmpty()) {
			helper_addStars(subStr, ans.append(IstChar));
		} else if (IstChar == ans.charAt(ans.length() - 1)) {
			helper_addStars(subStr, ans.append("*" + IstChar));
		} else {
			helper_addStars(subStr, ans.append(IstChar));
		}

	}

	public static void main(String[] args) {

		System.out.println(addStars("hello"));

		System.out.println(addStars("helo"));

		System.out.println(addStars("aaaa"));
	}
}
