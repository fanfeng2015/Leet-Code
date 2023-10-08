// LeetCode #1644 (Lowest Common Ancestor of a Binary Tree II).

// Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, 
// p and q. If either node p or q does not exist in the tree, return null. All values of the nodes
// in the tree are unique.

public class LowestCommonAncestorOfABinaryTree2 {

	// Assumptions:
	// 1. p != q
	// 2. All nodes of the tree have unique values.
	// 3. The given two nodes are NOT guaranteed to be in the binary tree.	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return root;
		}
		if (exist(root, p) && exist(root, q)) {
			return lowestCommonAncestor2(root, p, q);
		}
		return null;
	}

	private boolean exist(TreeNode root, TreeNode node) {
		if (root == null) {
			return false;
		}
		if (root == node) {
			return true;
		}
		return exist(root.left, node) || exist(root.right, node);
	}

	private TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor2(root.left, p, q);
		TreeNode right = lowestCommonAncestor2(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
