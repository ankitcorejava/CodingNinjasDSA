package com.BinarySearchTree;

class BTNode {

	int data;
	BTNode left;
	BTNode right;

	BTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;

	}
}

public class BinaryTree2 {

	public static void display(BTNode root) {

		if (root == null) {
			return;
		}

		int left_value = root.left == null ? 0 : root.left.data;
		int right_value = root.right == null ? 0 : root.right.data;

		System.out.println(left_value + " : " + root.data + " : " + right_value);

		display(root.left);
		display(root.right);

	}

	public static boolean searchInBST(BTNode root, int k) {

		if (root == null) {
			return false;
		}
		if (root.data == k) {
			return true;
		}

		if (k < root.data) {
			return searchInBST(root.left, k);
		} else if (k > root.data) {
			return searchInBST(root.right, k);
		}
		return false;
	}

	public static void elementsInRangeK1K2(BTNode root, int k1, int k2) {

		if (root == null) {
			return;
		}

		elementsInRangeK1K2(root.left, k1, k2);

		if (root.data >= k1 && root.data <= k2) {
			System.out.println(root.data);
		}

		elementsInRangeK1K2(root.right, k1, k2);

	}

	public static void isBST(BTNode root, boolean flag) {

		if (root == null) {
			return;
		}

		int left_value = root.left == null ? 0 : root.left.data;
		int right_value = root.right == null ? 0 : root.right.data;

		if (root.data > left_value) {
			flag = true;
			isBST(root.left, flag);
		} else {
			flag = false;
		}
		if (root.data < right_value) {
			flag = true;
			isBST(root.right, flag);
		} else {
			flag = false;
		}
	}

	public static void main(String[] args) {

		BTNode root = new BTNode(100);
		BTNode left = new BTNode(99);
		BTNode right = new BTNode(102);
		BTNode left_l = new BTNode(89);
		BTNode left_R = new BTNode(101);
		BTNode right_l = new BTNode(100);
		BTNode right_r = new BTNode(106);

		root.left = left;
		root.right = right;
		left.left = left_l;
		left.right = left_R;
		right.left = right_l;
		right.right = right_r;

		display(root);
		System.out.println(searchInBST(root, 102));

		elementsInRangeK1K2(root, 99, 106);

		boolean iState = false;
		isBST(root, iState);
		System.out.println(iState);
	}

}
