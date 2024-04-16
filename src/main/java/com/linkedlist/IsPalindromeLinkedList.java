package com.linkedlist;

import java.util.Stack;

/**
 * You have been given a head to a singly linked list of integers. Write a
 * function check to whether the list given is a 'Palindrome' or not.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= t <= 10^2 0 <= M <= 10^5 Time Limit: 1sec
 * 
 * Where 'M' is the size of the singly linked list. Sample Input 1 : 1 9 2 3 3 2
 * 9 -1 Sample Output 1 : true Sample Input 2 : 2 0 2 3 2 5 -1 -1 Sample Output
 * 2 : false true Explanation for the Sample Input 2 : For the first query, it
 * is pretty intuitive that the the given list is not a palindrome, hence the
 * output is 'false'.
 * 
 * For the second query, the list is empty. An empty list is always a palindrome
 * , hence the output is 'true'. } }
 * 
 */

public class IsPalindromeLinkedList {

	private Node head;

	static class Node {
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

	public Node insertAtEnd(Node newNode) {

		Node ref = this.head;

		if (this.head == null) {
			this.head = newNode;
		} else {
			while (ref.next != null) {
				ref = ref.next;
			}

			ref.next = newNode;
			// this.head = newNode;
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

	public static void display(Node head) {
		Node ref = head;

		while (ref != null) {
			System.out.print(ref.data + " -> ");
			ref = ref.next;

		}
	}

	public static Node insert(Node head, int pos, int data) {

		/*
		 * Node<Integer> newNode = new Node<Integer>(data); Node<Integer> ref = head;
		 */

		Node newNode = new Node(data);
		Node ref = head;

		int cpos = 0;
		if (ref == null) {
			ref = newNode;
		} else if (pos == 0) {
			newNode.next = ref;
			return newNode;
		} else {

			while ((ref.next != null) && (cpos < pos - 1)) {

				ref = ref.next;
				cpos++;
			}
			if (!(pos > (cpos + 1))) {
				Node pre = ref.next;
				ref.next = newNode;
				newNode.next = pre;
			}
		}

		return head;
	}

	public static Node deleteNode(Node head, int pos) {
		Node ref = head;

		int cpos = 0;
		if (ref == null) {
			return null;
		} else if (pos == 0) {
			return ref.next;
		} else {
			while ((ref.next.next != null) && (cpos < pos - 1)) {
				ref = ref.next;
				cpos++;
			}
			if (!(pos > (cpos + 1))) {
				ref.next = ref.next.next;
			}
		}

		return head;
	}

	public static int findNode(Node head, int n) {

		Node ref = head;
		if (ref == null) {
			return -1;
		}
		int idx = 0;

		while (ref != null) {
			if (ref.data == n) {
				return idx;
			}
			ref = ref.next;
			idx++;
		}

		return -1;
	}

	public static Node removeDuplicates(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node ref = head;
		// Node pre = head;

		while ((ref != null) && (ref.next != null)) {
			if (ref.next.data == -1) {
				break;
			}
			if (ref.data == ref.next.data) {
				ref.next = ref.next.next;
			} else {
				ref = ref.next;
			}
		}

		if (ref != null) {
			ref.next = null;
		}

		return head;
		// Your code goes here
	}

	public static boolean isPalindrome(Node head) {

		if (head == null || head.next == null) {
			return true;
		}

		Stack<Integer> stck = new Stack<Integer>();

		Node singleJump = head;
		// Node multiJump = head;
		int size = 0;
		//
		while ((singleJump != null && singleJump.data != -1)) {
			singleJump = singleJump.next;
			size++;
		}
		int icnt = 0;
		boolean isOdd = size % 2 != 0;

		int mid = isOdd ? (size / 2) : ((size / 2) - 1);

		Node currentRef = head;
		while (currentRef != null && currentRef.next != null) {
			/*if (currentRef.data == -1) {
				return true;
			}*/
			if (stck.isEmpty()) {
				stck.push(currentRef.data);
			} else if ((icnt < mid)) {
				stck.push(currentRef.data);
			} else if (isOdd && (icnt == mid)) {
				stck.push(currentRef.data);
				stck.pop();
			} else if (!isOdd && (icnt == mid)) {
				stck.push(currentRef.data);
			} else if ((icnt > mid)) {
				if (stck.peek() == currentRef.data) {
					stck.pop();
				}
			}
			currentRef = currentRef.next;
			icnt++;
		}

		return stck.isEmpty();
	}

	public static void main(String[] args) {

		IsPalindromeLinkedList s1 = new IsPalindromeLinkedList();
		Node newNode0 = new Node(2);
		s1.insertAtEnd(newNode0);
		Node newNode1 = new Node(3);
		s1.insertAtEnd(newNode1);
		Node newNode2 = new Node(5);
		s1.insertAtEnd(newNode2);
		Node newNode3 = new Node(3);
		s1.insertAtEnd(newNode3);
		// Node newNode13 = new Node(3);
		// s1.insertAtEnd(newNode13);

		Node newNode4 = new Node(2);
		// Node newNode14 = new Node(2);
		s1.insertAtEnd(newNode4);
		// s1.insertAtEnd(newNode14);
		// Node newNode5 = new Node(9);
		// s1.insertAtEnd(newNode5);
		Node newNode6 = new Node(-1);
		s1.insertAtEnd(newNode6);

		System.out.println();

		// s1.head = removeDuplicates(s1.head);

		display(s1.head);

		System.out.println(isPalindrome(s1.head));

	}

}
