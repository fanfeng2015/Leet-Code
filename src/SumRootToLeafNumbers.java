// LeetCode #129 (Sum Root to Leaf Numbers).

// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could
// represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// Note: A leaf is a node with no children.

public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root, 0);
	}

	private int helper(TreeNode root, int cur) { // root != null
		cur = 10 * cur + root.val;
		if (root.left == null && root.right == null) {
			return cur;
		}
		int left = (root.left == null) ? 0 : helper(root.left, cur);
		int right = (root.right == null) ? 0 : helper(root.right, cur);
		return left + right;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
