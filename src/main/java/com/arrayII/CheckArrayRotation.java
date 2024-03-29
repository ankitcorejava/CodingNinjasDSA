package com.arrayII;

/*
	You have been given an integer array/list(ARR) of size N. It has been sorted(in increasing order) 
	and then rotated by some number 'K' (K is greater than 0) in the right hand direction.
	Your task is to write a function that returns the value of 'K', that means, the index 
	from which the array/list has been rotated.
	Detailed explanation ( Input/output format, Notes, Images )
	Constraints :
	1 <= t <= 10^2
	2 <= N <= 10^5
	Time Limit: 1 sec
		Sample Input 1:
		1
		6
		5 6 1 2 3 4
		Sample Output 1:
		2 
 */
import java.util.Scanner;

public class CheckArrayRotation {
	public static int arrayRotateCheck(int[] arr) {
		// Your code goes here
		int iCnt = 0;
		if (arr.length < 1) {
			return 0;
		}

		if (arr[arr.length - 1] > arr[0]) {
			return 0;
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < arr[i + 1]) {
					iCnt++;
				} else {
					iCnt++;
					break;
				}

				//System.out.println(i);
			}
			return iCnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sr = new Scanner(System.in);
		int t = sr.nextInt();
		while (t > 0) {
			int n = sr.nextInt();
			int ar[] = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = sr.nextInt();
			}
			int ans = CheckArrayRotation.arrayRotateCheck(ar);
			System.out.println(ans);
			t = t - 1;
		}
	}

}
