// LeetCode #1650 (Lowest Common Ancestor of a Binary Tree III).

// Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

// Each node will have a reference to its parent node.

public class LowestCommonAncestorOfABinaryTree3 {

	private class Node {
		@SuppressWarnings("unused")
		public int val;
		@SuppressWarnings("unused")
		public Node left;
		@SuppressWarnings("unused")
		public Node right;
		public Node parent;
	};

	// Assumptions:
	// 1. p != q
	// 2. All nodes of the tree have unique values.
	// 3. The given two nodes are guaranteed to be in the binary tree.
	// 4. Each node has a pointer to its parent.
	public Node lowestCommonAncestor(Node p, Node q) {
		int lp = length(p), lq = length(q);
		if (lp < lq) {
			return lowestCommonAncestor(p, q, lq - lp);
		} else {
			return lowestCommonAncestor(q, p, lp - lq);
		}
	}

	private Node lowestCommonAncestor(Node shorter, Node longer, int diff) {
		for (int i = 0; i < diff; i++) {
			longer = longer.parent;
		}
		while (shorter != longer) {
			shorter = shorter.parent;
			longer = longer.parent;
		}
		return shorter;
	}

	private int length(Node node) {
		int len = 0;
		while (node != null) {
			len++;
			node = node.parent;
		}
		return len;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
