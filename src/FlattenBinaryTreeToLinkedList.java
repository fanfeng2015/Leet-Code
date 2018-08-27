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
	// Space complexity is O(n), when the binary tree is highly unbalanced.	
}
