// LeetCode #222 (Count Complete Tree Nodes).

// Given a complete binary tree, count the number of nodes.

public class CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
		int height = getHeight(root);
		if (height == 0) {
			return 0;
		}
		int right = getHeight(root.right);
		return right == height - 1 ? (1 << height - 1) + countNodes(root.right)
				: (1 << height - 2) + countNodes(root.left);
	}

	// Because this is a complete binary tree, height can be computed
	// in logarithmic time.
	// Any subtree of a complete binary tree is also a complete binary tree.
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + getHeight(root.left);
	}

	// Time complexity is O(log(n)*log(n)).
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
