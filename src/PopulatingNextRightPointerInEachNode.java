import java.util.LinkedList;

// LeetCode #116 (Populating Next Right Pointers in Each Node).

// You are given a perfect binary tree where all leaves are on the same level, and every parent has
// two children. The binary tree has the following definition:

// Populate each next pointer to point to its next right node. If there is no next right node, the 
// next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Follow-up:
// 1. You may only use constant extra space.
// 2. The recursive approach is fine. You may assume implicit stack space does not count as extra space
// for this problem.

public class PopulatingNextRightPointerInEachNode {

	private class Node {
		@SuppressWarnings("unused")
		private int val;
		private Node left;
		private Node right;
		private Node next;

		private Node() {
		}

		private Node(int _val) {
			val = _val;
		}

		private Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	// Solution 1: BFS
	public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node cur = queue.pollLast();
				cur.next = (i == size - 1) ? null : queue.peekLast();
				if (cur.left != null) {
					queue.offerFirst(cur.left);
				}
				if (cur.right != null) {
					queue.offerFirst(cur.right);
				}
			}
		}
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: in-place
	public Node connect2(Node root) {
		if (root == null) {
			return root;
		}
		Node prev = root, cur = null;
		while (prev.left != null) {
			cur = prev;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			prev = prev.left; // next level
		}
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
