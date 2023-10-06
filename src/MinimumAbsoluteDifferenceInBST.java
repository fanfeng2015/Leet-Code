import java.util.Stack;

// LeetCode #530 (Minimum Absolute Difference in BST).

// Given a binary search tree with non-negative values, find the minimum absolute difference
// between values of any two nodes.

public class MinimumAbsoluteDifferenceInBST {

	private int min = Integer.MAX_VALUE;
	private TreeNode prev = null;

	public int getMinimumDifference(TreeNode root) {
		inorderTraversal(root);
		return min;
	}

	// In-order traversal of a BST is a list of strictly increasing/decreasing
	// values.
	// The recursive function does 1). traversal, 2). potentially update min, 3).
	// set prev to the current largest value.
	private void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		if (prev != null) {
			min = Math.min(min, root.val - prev.val);
		}
		prev = root;
		inorderTraversal(root.right);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public int getMinimumDifference2(TreeNode root) {
		int min = Integer.MAX_VALUE;
		TreeNode cur = root, prev = null;
		Stack<TreeNode> stack = new Stack<>();
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (prev != null) {
					min = Math.min(min, Math.abs(cur.val - prev.val));
				}
				prev = cur;
				cur = cur.right;
			}
		}
		return min;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
