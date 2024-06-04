package com.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree {

	public static int height(BinaryTreeNode root) {

		if (root == null) {
			return 0;
		}

		int left_h = height(root.left);
		int right_h = height(root.right);

		int final_h = Math.max(left_h, right_h);

		return (final_h + 1);

	}

	public static int diameterOfBinaryTree(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}

		int ld = diameterOfBinaryTree(root.left);
		int rd = diameterOfBinaryTree(root.right);

		int rootHeight = height(root.left) + height(root.right) + 2;

		return Math.max(rootHeight, Math.max(ld, rd));

	}

	public static void display(BinaryTreeNode root) {
		if (root == null) {
			return;
		}

		int left = root.left == null ? 0 : root.left.data;
		int right = root.right == null ? 0 : root.right.data;

		System.out.println("L: " + left + " <--- Root: " + root.data + "  ---> R: " + right);

		display(root.left);
		display(root.right);

	}

	public static BinaryTreeNode everyNodeStoresSumOfAllAodesAtLeft(BinaryTreeNode root) {
		if (root == null || root.left == null || root.right == null) {
			return root;
		}

		everyNodeStoresSumOfAllAodesAtLeft(root.left);
		root.data = root.data + root.left.data;

		BinaryTreeNode noderight = everyNodeStoresSumOfAllAodesAtLeft(root.left.right);

		root.data = root.data + (noderight == null ? 0 : noderight.data);

		everyNodeStoresSumOfAllAodesAtLeft(root.right);

		return root;

	}

	public static boolean findElementOfBinaryTree(BinaryTreeNode root, int key) {

		boolean iState = false;

		if (root == null) {
			return false;
		}

		int left = root.left == null ? 0 : root.left.data;
		int right = root.right == null ? 0 : root.right.data;

		if (root.data == key || left == key || right == key) {
			iState = true;
		}

		boolean iState_left = findElementOfBinaryTree(root.left, key);
		boolean iState_right = findElementOfBinaryTree(root.right, key);

		if (iState_left == true || iState_right == true || iState == true) {
			iState = true;
		}

		return iState;
	}

	public static void levelOrderDisplay(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> parent_q = new ArrayDeque<>();
		Queue<BinaryTreeNode> child_q = new ArrayDeque<>();

		parent_q.add(root);

		while (parent_q.size() > 0 || child_q.size() > 0) {

			while (parent_q.size() > 0) {
				BinaryTreeNode top = parent_q.peek();
				System.out.print(top.data + " ");
				if (top.left != null) {
					child_q.add(top.left);
				}
				if (top.right != null) {
					child_q.add(top.right);
				}
				parent_q.poll();
			}
			System.out.println();
			parent_q = new ArrayDeque<>(child_q);
			child_q.clear();
		}

	}

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode childl = new BinaryTreeNode(2);
		BinaryTreeNode childR = new BinaryTreeNode(3);
		BinaryTreeNode childl_1 = new BinaryTreeNode(4);
		BinaryTreeNode childR_1 = new BinaryTreeNode(5);
		BinaryTreeNode childl_2 = new BinaryTreeNode(6);
		BinaryTreeNode childR_2 = new BinaryTreeNode(7);
		root.left = childl;
		root.right = childR;
		childl.left = childl_1;
		childl.right = childR_1;
		childR.left = childl_2;
		childR.right = childR_2;

		display(root);
		System.out.println("height: " + height(root));

		System.out.println("diameterOfBinaryTree : " + diameterOfBinaryTree(root));

		System.out.println();
		System.out.println("-----------------------------------------------------");
		levelOrderDisplay(root);

		/*
		 * everyNodeStoresSumOfAllAodesAtLeft(root);
		 * System.out.println("-----------------------------------------------------");
		 * display(root);
		 * 
		 * System.out.println();
		 * System.out.println("-----------------------------------------------------");
		 * System.out.println(findElementOfBinaryTree(root, 5));
		 */

	}

}
