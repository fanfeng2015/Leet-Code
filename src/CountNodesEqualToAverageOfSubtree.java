// LeetCode #2265 (Count Nodes Equal to Average of Subtree).

// Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in
// its subtree.

// Note:
// - The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
// - A subtree of root is a tree consisting of root and all of its descendants.

public class CountNodesEqualToAverageOfSubtree {

	private int result = 0;

	public int averageOfSubtree(TreeNode root) {
		dfs(root);
		return result;
	}

	private int[] dfs(TreeNode node) {
		if (node == null) {
			return new int[] { 0, 0 };
		}
		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
		int sum = left[0] + right[0] + node.val;
		int count = left[1] + right[1] + 1;
		if (sum / count == node.val) {
			result++;
		}
		return new int[] { sum, count };
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
