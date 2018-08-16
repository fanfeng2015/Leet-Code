// LeetCode #549 (Binary Tree Longest Consecutive Sequence II).

// Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

// Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and 
// [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, 
// the path can be in the child-Parent-child order, where not necessarily be parent-child order.

public class BinaryTreeLongestConsecutiveSequence2 {

	private int max = 0;

	public int longestConsecutive(TreeNode root) {
		helper(root);
		return max;
	}

	// Returns length of the longest consecutive increasing sequence, and length of
	// the longest consecutive decreasing sequence.
	private int[] helper(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}
		int increasing = 1, decreasing = 1;
		if (root.left != null) {
			int[] left = helper(root.left);
			if (root.val == root.left.val + 1) {
				increasing = left[0] + 1;
			} else if (root.val == root.left.val - 1) {
				decreasing = left[1] + 1;
			}
		}
		if (root.right != null) {
			int[] right = helper(root.right);
			if (root.val == root.right.val + 1) {
				increasing = Math.max(increasing, right[0] + 1);
			} else if (root.val == root.right.val - 1) {
				decreasing = Math.max(decreasing, right[1] + 1);
			}
		}
		max = Math.max(max, increasing + decreasing - 1);
		return new int[] { increasing, decreasing };
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
