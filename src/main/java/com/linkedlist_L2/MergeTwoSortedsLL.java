package com.linkedlist_L2;

/**
 * You have been given a singly linked list of integers. Write a function that
 * returns the index/position of integer data denoted by 'N' (if it exists).
 * Return -1 otherwise.
 * 
 * Note : Assume that the Indexing for the singly linked list always starts from
 * 0.
 */
public class MergeTwoSortedsLL {

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

	public Node insertAtStart(int data) {
		Node newNode = new Node(data);

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

	public static Node midPoint(Node head) {

		Node slowRef = head;
		Node fastRef = head;

		while ((fastRef != null) && (fastRef.next != null) && (fastRef.next.next != null)) {
			slowRef = slowRef.next;
			fastRef = fastRef.next.next;
		}

		System.out.println();

		System.out.println(slowRef.data);

		return slowRef;
	}

	public static Node mergeTwoSorteds(Node head1, Node head2) {

		Node t1 = head1;
		Node t2 = head2;

		Node dummpNode = new Node(999);
		Node refToDummy = dummpNode;

		while (t1 != null && t2 != null) {

			if (t1.data <= t2.data) {
				refToDummy.next = t1;
				t1 = t1.next;
			} else {
				refToDummy.next = t2;
				t2 = t2.next;
			}
			refToDummy = refToDummy.next;

		}
		if (t1 != null) {
			refToDummy.next = t1;
		}
		if (t2 != null) {
			refToDummy.next = t2;
		}
		return dummpNode.next;
	}

	public static void main(String[] args) {

		MergeTwoSortedsLL s1 = new MergeTwoSortedsLL();
		s1.insertAtStart(12);
		s1.insertAtStart(8);
		s1.insertAtStart(5);
		s1.insertAtStart(2);
		display(s1.head);

		System.out.println();

		MergeTwoSortedsLL s2 = new MergeTwoSortedsLL();
		s2.insertAtStart(9);
		s2.insertAtStart(6);
		s2.insertAtStart(3);
		display(s2.head);

		MergeTwoSortedsLL s3 = new MergeTwoSortedsLL();
		s3.head = mergeTwoSorteds(s1.head, s2.head);

		System.out.println();
		display(s3.head);

	}

}
