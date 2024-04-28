package com.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You have been given a queue that can store integers as the data. You are
 * required to write a function that reverses the populated queue itself without
 * using any other data structures.
 */
public class ReverseKElements {
	
	
	public static void reverseKElements(Queue<Integer> input, int k) {

		reverseKElements_helper(input, k);

		 for (int i = 0; i < input.size() - k-1; i++) {
			 System.out.println(input.peek());
			 input.add(input.poll());
	        }


	}

	public static void reverseKElements_helper(Queue<Integer> input, int k) {

		// Base Case:
		if (input.size() <= k) {
			return;
		}

		int removedElement = input.poll();
		reverseKElements_helper(input, k);
		input.add(removedElement);

	}

	public static void main(String[] args) {

		Queue<Integer> input = new ArrayDeque<>();
		input.add(8);
		input.add(15);
		input.add(1);
		input.add(10);

		System.out.println("Queue");

		input.stream().forEach(x -> System.out.print(" -> "+x));
		
		System.out.println();
		reverseKElements_helper(input,1-1);
		input.stream().forEach(x -> System.out.print(" -> "+x));

		System.out.println();
		System.out.println("Reverse Queue");

		reverseKElements(input,1-1);
		input.stream().forEach(x -> System.out.print(" -> "+x));
		

	}
}
