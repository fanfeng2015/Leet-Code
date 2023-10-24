// LeetCode #337 (House Robber III).

// The thief has found himself a new place for his thievery again. There is only one entrance to this area, called 
// root.

// Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all
// houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

// Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

public class HouseRobber3 {

	public int rob(TreeNode root) {
		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}

	// [rob, not rob]
	private int[] helper(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		return new int[] { root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1]) };
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
