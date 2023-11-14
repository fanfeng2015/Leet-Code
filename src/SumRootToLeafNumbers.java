// LeetCode #129 (Sum Root to Leaf Numbers).

// You are given the root of a binary tree containing digits from 0 to 9 only.

// Each root-to-leaf path in the tree represents a number.
// - For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.

// Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

// A leaf node is a node with no children.

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
