package com.linkedlist;

/**
 * You have been given a singly linked list of integers. Write a function that
 * returns the index/position of integer data denoted by 'N' (if it exists).
 * Return -1 otherwise.
 * 
 * Note : Assume that the Indexing for the singly linked list always starts from
 * 0.
 */
public class RemoveDuplicates {

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

	public static Node removeDuplicates(Node head) {

		if (head == null) {
			return null;
		}

		Node ref = head;
		// Node pre = head;

		while ((ref != null) && (ref.next != null) && (ref.next.data != -1)) {
			if (ref.data == ref.next.data) {
				ref.next = ref.next.next;
			}
			else {
			ref = ref.next;
			}
		}
		
		if(ref != null) {
			ref.next = null;
		}

		return head;
		// Your code goes here
	}

	public static void main(String[] args) {

		RemoveDuplicates s1 = new RemoveDuplicates();
		Node newNode1 = new Node(1);
		Node newNode2 = new Node(1);
		Node newNode3 = new Node(1);
		s1.insertAtStart(newNode1);
		s1.insertAtStart(newNode2);
		s1.insertAtStart(newNode3);
		// s1.display(s1.head);

		Node newNode4 = new Node(2);
		Node newNode5 = new Node(3);
		Node newNode6 = new Node(3);
		Node newNode8 = new Node(4);
		Node newNode9 = new Node(5);
		Node newNode10 = new Node(6);
		Node newNode11 = new Node(7);
		Node newNode12 = new Node(8);
		Node newNode13 = new Node(8);
		Node newNode14 = new Node(8);
		Node newNode15 = new Node(8);
		Node newNode16 = new Node(8);
		Node newNode17 = new Node(8);
		Node newNode18 = new Node(8);
		Node newNode19 = new Node(-1);
		s1.insertAtEnd(newNode4);
		s1.insertAtEnd(newNode5);
		s1.insertAtEnd(newNode6);
		s1.insertAtEnd(newNode8);
		s1.insertAtEnd(newNode9);
		s1.insertAtEnd(newNode10);
		s1.insertAtEnd(newNode11);
		s1.insertAtEnd(newNode12);
		s1.insertAtEnd(newNode13);
		s1.insertAtEnd(newNode14);
		s1.insertAtEnd(newNode15);
		s1.insertAtEnd(newNode16);
		s1.insertAtEnd(newNode17);
		s1.insertAtEnd(newNode18);
		s1.insertAtEnd(newNode19);
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

		s1.head = removeDuplicates(s1.head);
		
		s1.display(s1.head);

	}

}
