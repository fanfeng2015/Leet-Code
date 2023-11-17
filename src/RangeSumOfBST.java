// LeetCode #938 (Range Sum of BST).

// Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value
// in the inclusive range [low, high].

public class RangeSumOfBST {

	public int rangeSumBST(TreeNode root, int low, int high) {
		return dfs(root, low, high);
	}

	private int dfs(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}
		int cur = (root.val >= low && root.val <= high) ? root.val : 0;
		int left = dfs(root.left, low, high);
		int right = dfs(root.right, low, high);
		return cur + left + right;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
