// LeetCode #235 (Lowest Common Ancestor of a Binary Search Tree).

// Given a binary search tree (BST), find the lowest common ancestor (LCA) of 
// two given nodes in the BST.

// Notes:
// 1. All of the nodes' values will be unique.
// 2. p and q are different and both values will exist in the BST.

public class LowestCommonAncestorOfABinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}

	// Time complexity is O(n), when the BST is highly unbalanced, and p and q
	// are far away from root.
	// Space complexity is O(1).
}
