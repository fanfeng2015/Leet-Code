// LeetCode #114 (Flatten Binary Tree to Linked List).

// Given a binary tree, flatten it to a linked list in-place.

// The "linked list" should use the same TreeNode class where the right child pointer points to the next
// node in the list and the left child pointer is always null.

// The "linked list" should be in the same order as a pre-order traversal of the binary tree.

public class FlattenBinaryTreeToLinkedList {

	private TreeNode next = null;

	// recursive post-order
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.left = null;
		root.right = next;
		next = root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}

// First thought is usually pre-order traversal, but the question is how to figure out the last node
// of the flattened left subtree.

// Solution is usually to do it reversely, keeping a global pointer to the element you need, in this 
// case, the last node.
