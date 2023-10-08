// LeetCode #236 (Lowest Common Ancestor of a Binary Tree).

// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

public class LowestCommonAncestorOfABinaryTree {

	// Assumptions:
	// 1. p != q
	// 2. All nodes of the tree have unique values.
	// 3. The given two nodes are guaranteed to be in the binary tree.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
