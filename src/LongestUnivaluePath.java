// LeetCode #687 (Longest Univalue Path).

// Given a binary tree, find the length of the longest path where each node in the
// path has the same value. This path may or may not pass through the root.

// Note: The length of path between two nodes is represented by the number of edges
// between them.

public class LongestUnivaluePath {

	private int max = 0;

	public int longestUnivaluePath(TreeNode root) {
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		if (root.left == null || root.val != root.left.val) {
			left = 0;
		}
		if (root.right == null || root.val != root.right.val) {
			right = 0;
		}
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
