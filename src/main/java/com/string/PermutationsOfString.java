package com.string;

import java.util.ArrayList;

public class PermutationsOfString {

	public static boolean isPermutation(String str1, String str2) {
		// Your code goes here
		ArrayList<String> list = new ArrayList<String>();
		permutationsOfString(str1, list, "");

		return list.contains(str2);

	}

	public static void permutationsOfString(String str, ArrayList<String> ansList, String ans) {

		if (str == null || str.length() == 0) {
			System.out.println(ans);
			ansList.add(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			String subStr = str.replaceFirst(ch+"", "");
			permutationsOfString(subStr, ansList, ans + ch);
		}
	}

	public static void main(String[] args) {
		
		 ArrayList<String> list = new ArrayList<String>(); 
		 permutationsOfString("abb",list, ""); 
		 System.out.println(list);
		 

		System.out.println(isPermutation("listee", "sileet"));

	}

}
