// LeetCode #112 (Path Sum).

// Given the root of a binary tree and an integer targetSum, return true if the tree has a 
// root-to-leaf path such that adding up all the values along the path equals targetSum.

public class PathSum {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return targetSum == root.val;
		}
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}
