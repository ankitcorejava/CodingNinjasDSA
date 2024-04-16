package com.linkedlist_L2;

/**
 * You have been given a singly linked list of integers. Write a function that
 * returns the index/position of integer data denoted by 'N' (if it exists).
 * Return -1 otherwise.
 * 
 * Note : Assume that the Indexing for the singly linked list always starts from
 * 0.
 */
public class InsertRecursive {

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

	public static void printRecursive(Node head) {
		if (head == null) {
			return;
		}

		System.out.print(head.data + " ");
		printRecursive(head.next);
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

	/**
	 * 1->2->3 -- insert 4 at 1 position Smaller list = > 2->3 -- insert 4 at 0
	 * position
	 * 
	 * pos ==0; create a new node(4); newNode.next = 2 ->3; this.head = newNode;
	 * return this.head;
	 * 
	 **/
	public static Node insertRecursive(Node head, int elem, int pos) {

		if (head == null) {
			return head;
		}

		// Base Case
		if (pos == 0) {

			Node newNode = new Node(elem);
			newNode.next = head;
			head = newNode;
		}

		Node sub_head = insertRecursive(head.next, elem, pos - 1);
		head.next = sub_head;
		return head;

	}

	public static void main(String[] args) {

		InsertRecursive s1 = new InsertRecursive();
		Node newNode1 = new Node(10);
		Node newNode2 = new Node(20);
		Node newNode3 = new Node(30);
		s1.insertAtStart(newNode1);
		s1.insertAtStart(newNode2);
		s1.insertAtStart(newNode3);

		Node newNode4 = new Node(110);
		Node newNode5 = new Node(120);
		Node newNode6 = new Node(130);
		s1.insertAtEnd(newNode4);
		s1.insertAtEnd(newNode5);
		s1.insertAtEnd(newNode6);

		display(s1.head);

		System.out.println();

		insertRecursive(s1.head, 900, 4);

		printRecursive(s1.head);

	}

}
