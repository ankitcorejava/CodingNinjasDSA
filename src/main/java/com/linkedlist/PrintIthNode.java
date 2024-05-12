package com.linkedlist;

import java.util.List;

/**
 * You have been given a linked list of integers. Your task is to write a
 * function that deletes a node from a given position, 'POS'.
 * 
 * Note : Assume that the Indexing for the linked list always starts from 0.
 * 
 * If the position is greater than or equal to the length of the linked list,
 * you should return the same linked list without any change.
 */
public class PrintIthNode {

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

	public static Node reverseLL(Node head) {

		if (head == null) {
			return head;
		}

		Node current = head;
		Node previous = null;

		while (current != null) {
			Node nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}

		head = previous;
		return head;

	}

	public static Node appendLastNToFirst(Node head, int n) {

		if(head.data == -1) {
			return head;
		}
		
		head = reverseLL(head);

		Node current1 = head;
		Node currentRef = current1;
		Node current2 = new Node(-1); // Temp Ref

		int i = 1;
		while ((i < n) && (currentRef != null)) {
			currentRef = currentRef.next;
			i++;
		}
		current2.next = currentRef.next;
		currentRef.next = null;
		

		/*System.out.println("/n********current1********");
		display(current1);
		System.out.println("/n********Reverse current1********");*/
		head = reverseLL(current1);
		//display(head);
		

		/*System.out.println("/n********current2********");
		display(current2);*/
		
		//System.out.println("/n********Reverse current2********");
		Node head2 = reverseLL(current2.next);
		//display(head2);
		
		Node finalItr = head; 
		while(finalItr.next != null) {
			finalItr = finalItr.next;
		}
		finalItr.next = head2;

		return head;

	}

	public static void main(String[] args) {

		PrintIthNode s1 = new PrintIthNode();
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
		s1.insertAtEnd(newNode4);
		s1.insertAtEnd(newNode5);
		s1.insertAtEnd(newNode6);
		s1.display(s1.head);

		System.out.println();

		// Node newNode7 = new Node(125);
		s1.head = insert(s1.head, 0, 1);

		s1.head = insert(s1.head, 110, 91);

		s1.display(s1.head);

		System.out.println();

		s1.head = deleteNode(s1.head, 0);

		s1.display(s1.head);

		s1.head = reverseLL(s1.head);

		System.out.println("**************");

		s1.display(s1.head);

		System.out.println("******TTT********");

		s1.head =  appendLastNToFirst(s1.head, 2);
		
		System.out.println("******appendLastNToFirst********");
		
		s1.display(s1.head);
		

	}

}
