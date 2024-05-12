package com.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeImplementation {

	static class BinaryTree {

		int data;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	static class Pair {
		BinaryTree tree;
		int status;

		Pair(BinaryTree tree, int status) {
			this.tree = tree;
			this.status = status;
		}
	}

	public static void printTree(BinaryTree root) {

		if (root == null) {
			return;
		}

		int left = root.left == null ? -1 : root.left.data;
		int right = root.right == null ? -1 : root.right.data;

		System.out.println(left + " <--- " + root.data + " ---> " + right);

		printTree(root.left);
		printTree(root.right);

	}

	public static void printLevelWise(BinaryTree root) {
		if (root == null) {
			return;
		}

		Queue<BinaryTree> rootq = new ArrayDeque<>();
		rootq.add(root);
		Queue<BinaryTree> childq = new ArrayDeque<>();

		while (rootq.size() > 0 || childq.size() > 0) {
			while (rootq.size() > 0) {

				BinaryTree subroot = rootq.peek();
				if (subroot != null) {
					int left = subroot.left == null ? -1 : subroot.left.data;
					int right = subroot.right == null ? -1 : subroot.right.data;

					System.out.println(subroot.data + ":" + "L:" + left + ",R:" + right);
					if (subroot.left != null) {
						childq.add(subroot.left);
					}
					if (subroot.right != null) {
						childq.add(subroot.right);
					}
					rootq.poll();
				}
			}

			rootq = childq;
			childq = new ArrayDeque<>();
		}

	}

	public static void main(String[] args) {

		int input[] = { 5, 6, 10, 2, 3, -1, -1, -1, -1, -1, 9, -1, -1 };

		Stack<Pair> stack = new Stack<>();
		BinaryTree root = new BinaryTree(input[0]);
		Pair pr = new Pair(root, 1);
		stack.add(pr);

		int i = 0;

		while (stack.size() != 0) {
			Pair pairR = stack.peek();
			// status = 1;-- > new node to go on left:
			if (pairR.status == 1) {
				i++;
				if (input[i] != -1) {

					BinaryTree lefttree = new BinaryTree(input[i]);
					Pair lp = new Pair(lefttree, 1);
					pairR.tree.left = lefttree;
					stack.push(lp);
				} else {
					pairR.tree.left = null;
				}
				pairR.status++;
			}

			// status = 2;-- > new node to go on right:
			else if (pairR.status == 2) {
				i++;
				if (input[i] != -1) {

					BinaryTree lefttree = new BinaryTree(input[i]);
					Pair lp = new Pair(lefttree, 1);
					pairR.tree.right = lefttree;
					stack.push(lp);
				} else {
					pairR.tree.right = null;
				}
				pairR.status++;
			}
			// status = 3;-- > pop the parent node;
			else {
				stack.pop();
			}

		}

		// printTree(root);

		System.out.println();

		printLevelWise(root);
	}

}
