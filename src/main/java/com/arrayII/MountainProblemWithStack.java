package com.arrayII;

import java.util.Arrays;
import java.util.Stack;

public class MountainProblemWithStack {

	public static boolean validateMountainProblemWithStack(int[] arr) {

	    if(arr.length <1) {
	    	return false;
	    }
		int max = Arrays.stream(arr).max().getAsInt();
	    Stack<Integer> stack = new Stack<>();
	    boolean atMax = false;
	    stack.push(arr[0]);
	    
	    for(int i=1 ;i < arr.length; i++) {
	    	
	    	int top = stack.peek();
	    	if(arr[i] == max) {
	    		atMax = true;
	    		stack.push(arr[i]);
	    	}
	    	//Increasing Order
	    	else if((arr[i]> top) && (atMax == false)) {
	    		 stack.push(arr[i]);
	    	}
	    	//Decreasing Order
	    	else if((arr[i]< top) && (atMax == true)) {
	    		 stack.push(arr[i]);
	    	}
	    	else {
	    		return false;
	    	}
	    }
		
	    return true;

	}

	public static void main(String[] args) {

		int[] input = { 0, 3, 4, 2, 1 };
		System.out.println("{ 0, 3, 4, 2, 1 }: " + validateMountainProblemWithStack(input));

		int[] input2 = { 1, 0, 3, 4, 2, 1 };
		System.out.println(" {1, 0, 3, 4, 2, 1 }: " + validateMountainProblemWithStack(input2));

		int[] input3 = { -1, 0, 3, 4, 2, 1 };
		System.out.println(" {-1, 0, 3, 4, 2, 1 }: " + validateMountainProblemWithStack(input3));
		
		int[] input4 = { -1, 0, 3, 4, 2, 1 ,5};
		System.out.println("  { -1, 0, 3, 4, 2, 1 ,5}: " + validateMountainProblemWithStack(input4));
	}

}
