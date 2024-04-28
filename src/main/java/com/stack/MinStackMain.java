package com.stack;

import java.util.Collections;
import java.util.Stack;

class pair {
	int value;
	int minValue;

	pair(int value, int minValue) {
		this.value = value;
		this.minValue = minValue;
	}

	@Override
	public String toString() {
		return "pair [value=" + value + ", minValue=" + minValue + "]";
	}
}

class MinStack extends Stack<pair> {

	int min = Integer.MAX_VALUE;

	public void pushMin(int a) {
		if (min > a) {
			min = a;
		}
		this.push(new pair(a, min));
	}

	public void popMin() {

		if (!this.isEmpty()) {
			this.pop();
		}
	}

	public int getMin() {
		if (!this.isEmpty()) {
			return this.peek().minValue;
		} else {
			return -1; // NA
		}
	}
}

public class MinStackMain {

	public static void main(String[] args) {

		MinStack minStack = new MinStack();
		minStack.pushMin(10);
		minStack.pushMin(1);
		minStack.pushMin(2);
		minStack.pushMin(0);

		minStack.stream().forEach(x -> System.out.println(x));
		
		System.out.println( minStack.getMin());
		
		minStack.pop();
		System.out.println( minStack.getMin());

	}

}
