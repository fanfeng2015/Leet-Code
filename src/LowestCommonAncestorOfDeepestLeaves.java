// LeetCode #1123 (Lowest Common Ancestor of Deepest Leaves).

// Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

// Recall that:
// - The node of a binary tree is a leaf if and only if it has no children
// - The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
// - The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree
//   with root A.

public class LowestCommonAncestorOfDeepestLeaves {

	private class Pair {
		TreeNode node;
		int depth;

		Pair(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	// for a single node, its lca is itself
	public TreeNode lcaDeepestLeaves(TreeNode root) {
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
