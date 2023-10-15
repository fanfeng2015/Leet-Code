// LeetCode #1740 (Find Distance in a Binary Tree).

// Given the root of a binary tree and two integers p and q, return the distance between the nodes of
// value p and value q in the tree.

// The distance between two nodes is the number of edges on the path from one to the other.

public class FindDistanceInABinaryTree {

	public int findDistance(TreeNode root, int p, int q) {
		TreeNode lca = lca(root, p, q);
		if (lca.val == p || lca.val == q) {
			return Math.abs(distance(root, p) - distance(root, q));
		}
		return distance(lca, p) + distance(lca, q);
	}

	private TreeNode lca(TreeNode root, int p, int q) {
		if (root == null || root.val == p || root.val == q) {
			return root;
		}
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		return (left != null && right != null) ? root : (left == null) ? right : left;
	}

	private int distance(TreeNode root, int val) {
		if (root == null) {
			return -1;
		}
		if (root.val == val) {
			return 0;
		}
		int left = distance(root.left, val);
		int right = distance(root.right, val);
		return (left == -1 && right == -1) ? -1 : (left == -1) ? (right + 1) : (left + 1);
	}

	// Time complexity is O(2^n).
	// Space complexity is O(n).
}
