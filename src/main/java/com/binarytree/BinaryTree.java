package com.binarytree;

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

		root.data = root.data + (noderight == null? 0: noderight.data);
		
		everyNodeStoresSumOfAllAodesAtLeft(root.right);

		return root;

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

		everyNodeStoresSumOfAllAodesAtLeft(root);
		System.out.println("-----------------------------------------------------");
		display(root);

	}

}
