import java.util.LinkedList;

// LeetCode #958 (Check Completeness of a Binary Tree).

// Given the root of a binary tree, determine if it is a complete binary tree.

// In a complete binary tree, every level, except possibly the last, is completely filled, and all 
// nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive 
// at the last level h.

public class CheckCompletenessOfABinaryTree {

	public boolean isCompleteTree(TreeNode root) {
		boolean found = false; // a null has been found
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pollLast();
				if (node.left == null) {
					found = true;
				} else if (found) {
					return false;
				} else {
					queue.offerFirst(node.left);
				}
				if (node.right == null) {
					found = true;
				} else if (found) {
					return false;
				} else {
					queue.offerFirst(node.right);
				}
			}
		}
		return true;
	}

	// Time complexity is O(n)
	// Space complexity is O(n).
}
