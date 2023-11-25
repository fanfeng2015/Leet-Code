// LeetCode #404 (Sum of Left Leaves).

// Given the root of a binary tree, return the sum of all left leaves.

// A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

public class SumOfLeftLeaves {

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sumOfLeftLeaves(root, false);
	}

	private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if (root.left == null && root.right == null) {
			return isLeft ? root.val : 0;
		}
		int left = (root.left == null) ? 0 : sumOfLeftLeaves(root.left, true);
		int right = (root.right == null) ? 0 : sumOfLeftLeaves(root.right, false);
		return left + right;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
