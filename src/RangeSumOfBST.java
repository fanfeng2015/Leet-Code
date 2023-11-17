// LeetCode #938 (Range Sum of BST).

// Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value
// in the inclusive range [low, high].

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

	public int rangeSumBST2(TreeNode root, int low, int high) {
		int sum = 0;
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				if (cur.val > high) {
					break;
				}
				if (cur.val >= low && cur.val <= high) {
					sum += cur.val;
				}
				cur = cur.right;
			}
		}
		return sum;
	}

}
