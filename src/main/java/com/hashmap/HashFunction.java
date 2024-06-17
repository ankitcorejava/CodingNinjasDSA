package com.hashmap;

public class HashFunction {

	public static void main(String[] args) {

		String str = "amit";
		int ascii_sum = 0;
		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {

			ascii_sum = ascii_sum + Integer.valueOf(chars[i]);

		}

		System.out.println(ascii_sum%26);

	}

}
