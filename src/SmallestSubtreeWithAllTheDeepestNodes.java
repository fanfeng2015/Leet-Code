// LeetCode #865 (Smallest Subtree with all the Deepest Nodes).

// Given the root of a binary tree, the depth of each node is the shortest distance to the root.

// Return the smallest subtree such that it contains all the deepest nodes in the original tree.

// A node is called the deepest if it has the largest depth possible among any node in the entire tree.

// The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

public class SmallestSubtreeWithAllTheDeepestNodes {

	private class Pair {
		TreeNode node;
		int depth;

		Pair(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	// for a single node, its lca is itself
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		return helper(root).node;
	}

	// returns lca and depth, of the deepest leaves in the subtree rooted at node
	private Pair helper(TreeNode node) {
		if (node == null) {
			return new Pair(null, 0);
		}
		Pair p1 = helper(node.left);
		Pair p2 = helper(node.right);
		if (p1.depth > p2.depth) {
			return new Pair(p1.node, p1.depth + 1);
		} else if (p2.depth > p1.depth) {
			return new Pair(p2.node, p2.depth + 1);
		}
		// depths are equal, that means there are two leaves with the same depth in left
		// subtree and right subtree
		return new Pair(node, p1.depth + 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
