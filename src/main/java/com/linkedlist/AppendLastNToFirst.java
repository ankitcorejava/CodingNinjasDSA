package com.linkedlist;

/**
 * You have been given a singly linked list of integers along with an integer
 * 'N'. Write a function to append the last 'N' nodes towards the front of the
 * singly linked list and returns the new head to the list.
 * 
 * Hint: Identify how many pointers you require and try traversing them to right
 * places and connect nodes accordingly also don't forget to disconnect what's
 * required else it could create cycles. Detailed explanation ( Input/output
 * format, Notes, Images ) Constraints : 1 <= t <= 10^2 0 <= M <= 10^5 0 <= N <
 * M Time Limit: 1sec
 * 
 * Where 'M' is the size of the singly linked list.
 */
public class AppendLastNToFirst {

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

		if (ref == null) {
			ref = newNode;
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

	public static Node appendLastNToFirst(Node head, int n) {

		Node ref = head;
		int size = 0;
		while (ref.data != -1) {
			ref = ref.next;
			size++;
		}

		Node ref1 = head;
		Node prev = ref1;
		int idx = 0;
		while (idx < ((size - n) - 2)) {
			ref1 = ref1.next;
			idx++;
		}
	    ref1.next = null;

		// 2nd Part
		Node ref2 = head;
		int idx1 = 0;
		while (idx1 < ((size - n) - 1)) {
			ref2 = ref2.next;
			idx1++;
		}

		Node prev2 = ref2;
		Node ref3 = ref2;

		while (ref3.next.data != -1) {

			ref3 = ref3.next;
		}
		ref3.next = prev;

		return prev2;

	}

	public static void main(String[] args) {

		AppendLastNToFirst s1 = new AppendLastNToFirst();
		Node newNode1 = new Node(10);
		Node newNode2 = new Node(20);
		Node newNode3 = new Node(30);
		s1.insertAtStart(newNode1);
		s1.insertAtStart(newNode2);
		s1.insertAtStart(newNode3);
		// s1.display(s1.head);

		Node newNode4 = new Node(110);
		Node newNode5 = new Node(120);
		Node newNode6 = new Node(130);
		Node newNode7 = new Node(-1);
		s1.insertAtEnd(newNode4);
		s1.insertAtEnd(newNode5);
		s1.insertAtEnd(newNode6);
		s1.insertAtEnd(newNode7);
		s1.display(s1.head);

		System.out.println();

		// Node newNode7 = new Node(125);
		s1.head = insert(s1.head, 0, 1);

		s1.head = insert(s1.head, 110, 91);

		s1.display(s1.head);

		System.out.println();

		s1.head = deleteNode(s1.head, 0);

		s1.display(s1.head);

		System.out.println();

		s1.head = appendLastNToFirst(s1.head, 3);
		s1.display(s1.head);

	}

}
