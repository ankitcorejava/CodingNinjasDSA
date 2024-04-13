package com.linkedlist;

import java.util.List;

/**
 * Given the head of a singly linked list of integers, find and return its
 * length.
 * 
 * 
 * Example: Sample Linked List
 * 
 * The length of the list is 4. Hence we return 4.
 * 
 * Note: Exercise caution when dealing with edge cases, such as when the head is
 * NULL. Failing to handle these edge cases appropriately may result in a
 * runtime error in your code.
 */
public class SinglyLinkedLength {

	private Node head;

	class Node {
		public int data;
		public Node next;

		Node() {
			this.data = 0;
			this.next = null;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public Node insertAtStart(Node newNode) {

		if (this.head == null) {
			this.head = newNode;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
		return this.head;

	}

	public static int length(Node head) {

		int iCnt = 0;
		Node ref = head;

		while (ref != null) {
			iCnt++;
			ref = ref.next;

		}

		return iCnt;
	}

	public static void main(String[] args) {

		SinglyLinkedLength s1 = new SinglyLinkedLength();
		Node newNode1 = s1.new Node(10);
		Node newNode2 = s1.new Node(20);
		Node newNode3 = s1.new Node(30);
		s1.insertAtStart(newNode1);
		s1.insertAtStart(newNode2);
		s1.insertAtStart(newNode3);
		System.out.println(s1.length(s1.head));

	}

}
