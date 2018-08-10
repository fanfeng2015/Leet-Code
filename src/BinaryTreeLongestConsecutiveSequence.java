// LeetCode #298 (Binary Tree Longest Consecutive Sequence).

// Given a binary tree, find the length of the longest consecutive sequence path.

// The path refers to any sequence of nodes from some starting node to any node in
// the tree along the parent-child connections. The longest consecutive path need 
// to be from parent to child (cannot be the reverse).

public class BinaryTreeLongestConsecutiveSequence {

	private int max = 0;

	public int longestConsecutive(TreeNode root) {
		helper(root);
		return max;
	}

	// returns length of the longest consecutive sequence starting from root
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		if (root.left == null || root.val != root.left.val - 1) {
			left = 0;
		}
		if (root.right == null || root.val != root.right.val - 1) {
			right = 0;
		}
		max = Math.max(max, Math.max(left, right) + 1);
		return Math.max(left, right) + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
