package com.linkedlist;

/**
 * You have been given a singly linked list of integers. Write a function that
 * returns the index/position of integer data denoted by 'N' (if it exists).
 * Return -1 otherwise.
 * 
 * Note : Assume that the Indexing for the singly linked list always starts from
 * 0.
 */
public class ReverseNode {

	private static Node head;

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

	public static void printReverse(Node root) {
		// Your code goes here
		Node loop = root;
		Node pre = null;
		Node current = root;

		while (loop != null) {
			loop = loop.next;
			current.next = pre;
			pre = current;
			current = loop;

		}
		display(pre);
		// return pre;
	}

	public static Node reverse(Node root) {
		// Your code goes here
		Node loop = root;
		Node pre = null;
		Node current = root;

		while (loop != null) {
			loop = loop.next;
			current.next = pre;
			pre = current;
			current = loop;

		}

		return pre;
	}

	public static Node kReverse(Node root, int k) {
		if (root == null) {
			return root;
		}

		Node itr = root;
		Node ref = itr;

		Node temp = new Node(-1);
		Node tempRef = temp;

		while (ref != null) {

			Node pointer = ref;
			int i = 1;
			while ((i < k) && (ref.next != null)) {

				ref = ref.next;
				i++;
			}

			Node ref2 = ref.next; //Next reference

			ref.next = null;
			Node temp2 = reverse(pointer);
			
			/*System.out.println("*****************");
			display(temp2);*/

			tempRef.next = temp2;
			while (tempRef.next != null) {
				tempRef = tempRef.next;
			}
			ref = ref2;
		}

		return temp;
	}

	public static void main(String[] args) {

		ReverseNode s1 = new ReverseNode();
		Node newNode0 = new Node(1);
		s1.insertAtEnd(newNode0);
		Node newNode1 = new Node(1);
		s1.insertAtEnd(newNode1);
		Node newNode2 = new Node(1);
		s1.insertAtEnd(newNode2);
		Node newNode3 = new Node(2);
		s1.insertAtEnd(newNode3);
		Node newNode4 = new Node(3);
		s1.insertAtEnd(newNode4);
		Node newNode5 = new Node(3);
		s1.insertAtEnd(newNode5);
		Node newNode6 = new Node(4);
		s1.insertAtEnd(newNode6);
		Node newNode7 = new Node(5);
		s1.insertAtEnd(newNode7);
		Node newNode8 = new Node(6);
		s1.insertAtEnd(newNode8);
		Node newNode9 = new Node(7);
		s1.insertAtEnd(newNode9);
		Node newNode10 = new Node(8);
		s1.insertAtEnd(newNode10);
		Node newNode1000 = new Node(9);
		s1.insertAtEnd(newNode1000);

		// display(s1.head);

		System.out.println();

		s1.head = removeDuplicates(s1.head);

		display(s1.head);

		System.out.println();
		//printReverse(head);

		System.out.println("**************************");
		head = kReverse(head, 2);
		display(head);

	}

}
