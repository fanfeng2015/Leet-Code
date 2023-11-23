// LeetCode #270 (Closest Binary Search Tree Value).

// Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
// If there are multiple answers, print the smallest.

public class ClosestBinarySearchTreeValue {

	// recursive
	public int closestValue(TreeNode root, double target) {
		if ((root.left == null && root.right == null) || root.val == target) {
			return root.val;
		}
		if (root.val < target) {
			if (root.right == null) {
				return root.val;
			} else {
				int right = closestValue(root.right, target);
				return Math.abs(root.val - target) <= Math.abs(right - target) ? root.val : right;
			}
		}
		if (root.val > target) {
			if (root.left == null) {
				return root.val;
			} else {
				int left = closestValue(root.left, target);
				// return the smaller if equal, thus < not <=
				return Math.abs(root.val - target) < Math.abs(left - target) ? root.val : left;
			}
		}
		// will never reach this point
		return Integer.MIN_VALUE;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(log(n)).

	// iterative
	public int closestValue2(TreeNode root, double target) {
		if ((root.left == null && root.right == null) || root.val == target) {
			return root.val;
		}
		int result = root.val;
		while (root != null) {
			if (root.val == target) {
				return root.val;
			} else {
				if (Math.abs(root.val - target) < Math.abs(result - target)) {
					result = root.val;
				}
				// return the smaller if equal
				if (Math.abs(root.val - target) == Math.abs(result - target) && root.val < target) {
					result = root.val;
				}
				if (root.val < target) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}
		return result;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
