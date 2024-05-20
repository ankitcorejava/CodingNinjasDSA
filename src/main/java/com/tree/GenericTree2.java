package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class GTNode {
	@Override
	public String toString() {
		return "GTNode [data=" + data + ", children=" + children + "]";
	}

	int data;
	List<GTNode> children;

	public GTNode(int data) {
		this.data = data;
		this.children = new ArrayList<>();
	}
}

public class GenericTree2 {

	public static void main(String[] args) {

		GenericTree2 gt = new GenericTree2();
		GTNode root = new GTNode(100);
		GTNode child1 = new GTNode(80);
		GTNode child2 = new GTNode(90);
		GTNode child3 = new GTNode(70);
		GTNode child1_1 = new GTNode(81);
		GTNode child1_2 = new GTNode(82);
		GTNode child1_3 = new GTNode(83);
		GTNode child2_1 = new GTNode(91);
		GTNode child2_2 = new GTNode(92);
		GTNode child3_1 = new GTNode(71);
		GTNode child3_2 = new GTNode(722);
		root.children.add(child1);
		root.children.add(child2);
		root.children.add(child3);
		child1.children.add(child1_1);
		child1.children.add(child1_2);
		child1.children.add(child1_3);
		child2.children.add(child2_1);
		child2.children.add(child2_2);
		child3.children.add(child3_1);
		child3.children.add(child3_2);
		//gt.display(root);

		// Root2
		GTNode root2 = new GTNode(100);
		GTNode child01 = new GTNode(80);
		GTNode child02 = new GTNode(90);
		GTNode child03 = new GTNode(70);
		GTNode child01_1 = new GTNode(81);
		GTNode child01_2 = new GTNode(82);
		GTNode child01_3 = new GTNode(83);
		GTNode child02_1 = new GTNode(91);
		GTNode child02_2 = new GTNode(92);
		GTNode child03_1 = new GTNode(71);
		GTNode child03_2 = new GTNode(72);
		root2.children.add(child01);
		root2.children.add(child02);
		root2.children.add(child03);
		child01.children.add(child01_1);
		child01.children.add(child01_2);
		child01.children.add(child01_3);
		child02.children.add(child02_1);
		child02.children.add(child02_2);
		child03.children.add(child03_1);
		child03.children.add(child03_2);
		
		

		//gt.display(root2);
		
		gt.printPostOrder(root2);

		/*System.out.println(checkIdentical(root, root2));
		
		gt.levelOrderPrinting(root);

		System.out.println(levelOrderPrinting2(root));
		
		System.out.println("maxSumNode: " + maxSumNode(root));*/

	}

	
	public void display(GTNode root) {

		System.out.print(root.data + " : ");

		for (GTNode child : root.children) {
			System.out.print(child.data + " -> ");
		}

		System.out.println();

		for (GTNode child : root.children) {
			display(child);
		}

	}

	public static boolean checkIdentical(GTNode root1, GTNode root2) {

		List<Integer> list1 = levelOrderPrinting2(root1);

		List<Integer> list2 = levelOrderPrinting2(root2);

		if (list1.size() != list2.size()) {
			return false;
		}

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i)) {
				return false;
			}
		}
		return true;

	}

	public void levelOrderPrinting(GTNode root) {

		System.out.println("***************   levelOrderPrinting    ******************");

		if (root == null) {
			return;
		}

		Queue<GTNode> parent_q = new ArrayDeque<>();
		Queue<GTNode> child_q = new ArrayDeque<>();

		// Add parent & child;
		parent_q.add(root);

		while (parent_q.size() > 0 || child_q.size() > 0) {

			while (parent_q.size() > 0) {
				GTNode parent = parent_q.peek();

				// Add Child:
				for (GTNode child : parent.children) {
					child_q.add(child);
				}

				System.out.print(parent_q.poll().data + " , ");

			}
			System.out.println();
			parent_q = new ArrayDeque<>(child_q);
			child_q = new ArrayDeque<>();
		}

	}

	public static List<Integer> levelOrderPrinting2(GTNode root) {

		System.out.println("***************   levelOrderPrinting 2   ******************");

		List<Integer> list = new ArrayList<Integer>();

		if (root == null) {
			return null;
		}

		Queue<GTNode> parent_q = new ArrayDeque<>();
		Queue<GTNode> child_q = new ArrayDeque<>();

		// Add parent & child;
		parent_q.add(root);

		while (parent_q.size() > 0 || child_q.size() > 0) {

			while (parent_q.size() > 0) {
				GTNode parent = parent_q.peek();

				// Add Child:
				for (GTNode child : parent.children) {
					child_q.add(child);
				}

				// System.out.print(parent_q.poll().data + " , ");
				list.add(parent_q.poll().data);

			}
			System.out.println();
			parent_q = new ArrayDeque<>(child_q);
			child_q = new ArrayDeque<>();
		}
		return list;

	}
	
	static class Pair{
		
		GTNode node; 
		int maxData;
		
		public GTNode getNode() {
			return node;
		}

		public void setNode(GTNode node) {
			this.node = node;
		}

		public int getMaxData() {
			return maxData;
		}

		public void setMaxData(int maxData) {
			this.maxData = maxData;
		}

		public Pair() {
			this.node = null; 
			this.maxData = Integer.MIN_VALUE;
		}
		
	}
	
	public static GTNode maxSumNode(GTNode root) {
		
		Pair pair = new Pair();
		
		int sum =0;

		if (root == null) {
			return root;
		}

		Queue<GTNode> parent_q = new ArrayDeque<>();
		Queue<GTNode> child_q = new ArrayDeque<>();

		// Add parent & child;
		parent_q.add(root);

		while (parent_q.size() > 0 || child_q.size() > 0) {

			while (parent_q.size() > 0) {
				sum =0;
				GTNode parent = parent_q.peek();

				// Add Child:
				for (GTNode child : parent.children) {
					child_q.add(child);
					sum = sum+ child.data;
				}
				sum = sum + parent.data;
				if(pair.maxData < sum) {
					
					pair.setMaxData(sum);
					pair.setNode(parent);
				}
				parent_q.poll();

			}
			System.out.println();
			parent_q = new ArrayDeque<>(child_q);
			child_q = new ArrayDeque<>();
		}
		return pair.getNode();

	}
	
	
	public void printPostOrder_helper(GTNode root) {	
		
		if(root == null) {
			return;
		}

		for (GTNode child : root.children) {
			printPostOrder_helper(child);
		}

		System.out.print(root.data + " ");

	}
	
	
	private void printPostOrder(GTNode root) {
		// TODO Auto-generated method stub
		printPostOrder_helper( root) ;
		
		
		
	}


}
