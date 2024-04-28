package com.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You have been given a queue that can store integers as the data. You are
 * required to write a function that reverses the populated queue itself without
 * using any other data structures.
 */
public class ReverseQueue {

	public static void reverseQueue(Queue<Integer> input) {
		
		//Base Case:
		if(input.size() ==0) {
			return;
		}

		int removedElement = input.poll();
		reverseQueue(input);
		input.add(removedElement);

	}

	public static void main(String[] args) {

		Queue<Integer> input = new ArrayDeque<>();
		input.add(10);
		input.add(20);
		input.add(30);
		input.add(40);
		input.add(50);

		System.out.println("Queue");

		input.stream().forEach(x -> System.out.println(x));

		System.out.println("Reverse Queue");

		reverseQueue(input);

		input.stream().forEach(x -> System.out.println(x));

	}
}
