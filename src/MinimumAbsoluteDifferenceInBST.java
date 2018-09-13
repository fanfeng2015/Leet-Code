import java.util.Stack;

// LeetCode #530 (Minimum Absolute Difference in BST).

// Given a binary search tree with non-negative values, find the minimum absolute difference
// between values of any two nodes.

public class MinimumAbsoluteDifferenceInBST {

	public int getMinimumDifference(TreeNode root) {
		int min = Integer.MAX_VALUE;
		TreeNode cur = root, prev = null;
		Stack<TreeNode> stack = new Stack<>();
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (prev != null && Math.abs(cur.val - prev.val) < min) {
					min = Math.abs(cur.val - prev.val);
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
