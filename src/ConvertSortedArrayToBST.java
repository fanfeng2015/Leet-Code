// LeetCode #108 (Convert Sorted Array to BST).

// Given an array where elements are sorted in ascending order, 
// convert it to a height balanced BST.

public class ConvertSortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, left, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, right);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(log(n)).

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
