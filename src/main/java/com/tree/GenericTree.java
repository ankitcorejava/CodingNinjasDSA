package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GenericTree {

	static class TreeNode {
		int data;
		ArrayList<TreeNode> children;

		TreeNode(int data) {
			this.data = data;
			this.children = new ArrayList<TreeNode>();
		}
	}

	public static void printTreeNode(TreeNode root) {

		System.out.print(root.data + " : ");

		for (TreeNode child : root.children) {
			System.out.print(child.data + " -> ");
		}

		System.out.println();
		for (TreeNode child : root.children) {
			printTreeNode(child);
		}
	}

	public static boolean checkIfContainsX(TreeNode root, int x) {

		boolean status = false;

		if (root.data == x) {
			status = true;
		}

		for (TreeNode child : root.children) {
			boolean sub_status = checkIfContainsX(child, x);
			if (status == true || sub_status == true) {
				status = true;
			}
		}
		return status;
	}

	public static TreeNode findNextLargerNode(TreeNode root, int n) {

		TreeNode ref = new TreeNode(Integer.MAX_VALUE);
		if (root.data > n) {
			ref = root;
		}

		for (TreeNode child : root.children) {
			TreeNode ref1 = findNextLargerNode(child, n);
			ref = Math.min(ref1.data, ref.data) == ref1.data ? ref1 : ref;
		}

		return ref;

	}

	public static TreeNode findNextLargerNode2(TreeNode root, int n) {

		TreeNode ref = new TreeNode(Integer.MIN_VALUE);
		if (root.data < n) {
			ref = root;
		}

		for (TreeNode child : root.children) {
			TreeNode ref1 = findNextLargerNode2(child, n);
			ref = Math.max(ref1.data, ref.data) == ref1.data ? ref1 : ref;
		}

		return ref;

	}

	public static TreeNode findLargest(TreeNode root) {

		TreeNode ref = new TreeNode(Integer.MIN_VALUE);
		if (root.data > ref.data) {
			ref = root;
		}

		for (TreeNode child : root.children) {
			TreeNode ref1 = findLargest(child);
			ref = Math.max(ref1.data, ref.data) == ref1.data ? ref1 : ref;
		}

		return ref;

	}

	public static TreeNode findSecondLargest(TreeNode root) {

		TreeNode largestTree = findLargest(root);
		System.out.println(largestTree.data);
		return findNextLargerNode2(root, largestTree.data);

	}

	public static int countLeafNodes(TreeNode root) {

		int iCnt = 0;
		if (root.children.size() == 0) {
			iCnt += 1;
		}
		for (TreeNode child : root.children) {
			int iCnt1 = countLeafNodes(child);
			iCnt = iCnt + iCnt1;
		}
		return iCnt;
	}

	public static void replaceWithDepthValue(TreeNode root) {

		if (root == null) {
			return;
		}
		int level =0; 
		Queue<TreeNode> rootq = new ArrayDeque<>();
		Queue<TreeNode> childq = new ArrayDeque<>();

		rootq.add(root);

		while ((!rootq.isEmpty()) || (!childq.isEmpty())) {

			
			
			while (!rootq.isEmpty()) {

				rootq.peek().data = level;
				for (TreeNode child : rootq.peek().children) {
					childq.add(child);
				}
				
				System.out.print(rootq.poll().data+" ");
				
				//System.out.print(rootq.peek().data+" ");
				
			}
			rootq = childq;
			childq = new ArrayDeque<>();
			System.out.println();
			level++;
		}
	}
	
	public static void levelWiseOrderPrinting(TreeNode root) {

		if (root == null) {
			return;
		}
		Queue<TreeNode> rootq = new ArrayDeque<>();
		Queue<TreeNode> childq = new ArrayDeque<>();

		rootq.add(root);

		while ((!rootq.isEmpty()) || (!childq.isEmpty())) {

			while (!rootq.isEmpty()) {

				for (TreeNode child : rootq.peek().children) {
					childq.add(child);
				}
				System.out.print(rootq.poll().data+" ");
				
			}
			rootq = childq;
			childq = new ArrayDeque<>();
			System.out.println();
		}
	}


	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		TreeNode child1 = new TreeNode(20);
		TreeNode child2 = new TreeNode(30);
		TreeNode child3 = new TreeNode(40);
		TreeNode child1_1 = new TreeNode(120);
		TreeNode child1_2 = new TreeNode(220);
		TreeNode child1_3 = new TreeNode(320);
		TreeNode child2_1 = new TreeNode(130);
		TreeNode child2_2 = new TreeNode(230);
		TreeNode child2_3 = new TreeNode(330);
		TreeNode child3_1 = new TreeNode(140);
		TreeNode child3_2 = new TreeNode(240);
		TreeNode child3_3 = new TreeNode(340);

		root.children.add(child1);
		root.children.add(child2);
		root.children.add(child3);

		child1.children.add(child1_1);
		child1.children.add(child1_2);
		child1.children.add(child1_3);

		child2.children.add(child2_1);
		child2.children.add(child2_2);
		child2.children.add(child2_3);

		child3.children.add(child3_1);
		child3.children.add(child3_2);
		child3.children.add(child3_3);

		printTreeNode(root);

		System.out.println("******************");
		System.out.println(checkIfContainsX(root, 30));

		System.out.println("******************");
		System.out.println(findNextLargerNode(root, 44).data);

		System.out.println("******************");
		System.out.println(findLargest(root).data);

		System.out.println("******************");
		System.out.println(findSecondLargest(root).data);

		System.out.println("******************");
		System.out.println("countLeafNodes: " + countLeafNodes(root));

		System.out.println("******************");
		replaceWithDepthValue(root);
		

		System.out.println("********printTreeNode**********");
		printTreeNode(root);
		
		

	}
}
