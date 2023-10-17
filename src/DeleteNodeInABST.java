// LeetCode #450 (Delete Node in a BST).

// Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
// Return the root node reference (possibly updated) of the BST.

// Basically, the deletion can be divided into two stages:
// 1. Search for a node to remove.
// 2. If the node is found, delete the node.

public class DeleteNodeInABST {

	// recursive
	public TreeNode deleteNode(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val < val) {
			root.right = deleteNode(root.right, val);
			return root;
		} else if (root.val > val) {
			root.left = deleteNode(root.left, val);
			return root;
		}
		return deleteRootNode(root);
	}

	private TreeNode deleteRootNode(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null) {
			return root.right;
		}
		if (root.right == null) {
			return root.left;
		}
		TreeNode right = root.right;
		if (right.left == null) { // right should be promoted to be the new root
			right.left = root.left;
			// root.right = null;
			return right;
		} else {
			TreeNode smallest = deleteSmallest(right);
			smallest.left = root.left;
			smallest.right = right;
			// root.left = null;
			// root.right = null;
			return smallest;
		}
	}

	private TreeNode deleteSmallest(TreeNode root) {
		TreeNode prev = root;
		TreeNode cur = root.left; // guaranteed to be non-null
		while (cur.left != null) {
			prev = cur;
			cur = cur.left;
		}
		prev.left = cur.right;
		return cur;
	}

	// iterative
	public TreeNode deleteNode2(TreeNode root, int val) {
		TreeNode cur = root, prev = null;
		while (cur != null && cur.val != val) {
			prev = cur;
			if (cur.val < val) {
				cur = cur.right;
			} else if (cur.val > val) {
				cur = cur.left;
			}
		}
		// cur == null || cur.val == val
		if (prev == null) {
			return deleteRootNode(cur);
		}
		if (prev.left == cur) {
			prev.left = deleteRootNode(cur);
		} else {
			prev.right = deleteRootNode(cur);
		}
		return root;
	}

	// Time complexity is O(n), when the binary tree is highly unbalanced.
	// Space complexity is O(1) for iterative and O(n) for recursive.
}
