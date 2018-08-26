// LeetCode #114 (Flatten Binary Tree to Linked List).

// Given a binary tree, flatten it to a linked list in-place.

public class FlattenBinaryTreeToLinkedList {

	private TreeNode next = null;

	// recursive post-order
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.right = next;
		root.left = null;
		next = root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when binary tree is highly unbalanced.

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
}
