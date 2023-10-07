import java.util.LinkedList;

// LeetCode #1161 (Maximum Level Sum of a Binary Tree).

// Given the root of a binary tree, the level of its root is 1, the level of its children is 2, 
// and so on.

// Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

public class MaximumLevelSumOfABinaryTree {

	public int maxLevelSum(TreeNode root) {
		int max = Integer.MIN_VALUE, result = 0, level = 0;
		if (root == null) {
			return max;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerFirst(root);
		while (queue.size() > 0) {
			level++;
			int size = queue.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.pollLast();
				sum += cur.val;
				if (cur.left != null) {
					queue.offerFirst(cur.left);
				}
				if (cur.right != null) {
					queue.offerFirst(cur.right);
				}
			}
			if (sum > max) {
				max = sum;
				result = level;
			}

		}
		return result;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n).	
}
