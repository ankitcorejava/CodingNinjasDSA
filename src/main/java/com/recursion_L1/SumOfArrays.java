package com.recursion_L1;

/*
 * Given an array of length N, you need to find and return the sum of all elements of the array.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 9
Sample Output 1 :
26
Sample Input 2 :
3
4 2 1
Sample Output 2 :
7    
public class Solution {

	public static int sum(int input[]) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/

public class SumOfArrays {

	public static int sum(int input[]) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
		return subSum(input, 0);

	}

	public static int subSum(int input[], int startIdx) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
		// Base Case::
		if (startIdx == input.length) {
			return 0;
		}

		int subSums = subSum(input, startIdx + 1);

		return (subSums + input[startIdx]);

	}
	
	public static void main(String[] args) {
		
		int input[] = {1,2,3,40};
		
		System.out.println(subSum(input,0));
	}

}
