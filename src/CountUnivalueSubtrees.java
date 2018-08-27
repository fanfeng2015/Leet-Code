// LeetCode #250 (Count Univalue Subtrees).

// Given a binary tree, count the number of uni-value subtrees.

// A Uni-value subtree means all nodes of the subtree have the same value.

public class CountUnivalueSubtrees {

	private int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		isUnivalSubtree(root);
		return count;
	}

	private boolean isUnivalSubtree(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean left = isUnivalSubtree(root.left);
		boolean right = isUnivalSubtree(root.right);
		if (left && right && sameAsChild(root)) {
			count++;
			return true;
		}
		return false;
	}

	private boolean sameAsChild(TreeNode root) {
		return (root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}
