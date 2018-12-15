import java.util.LinkedList;

// LeetCode #111 (Minimum Depth of Binary Tree).

// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path 
// from the root node down to the nearest leaf node.

public class MinimumDepthOfBinaryTree {

	// recursive
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when binary tree is highly unbalanced.

	// BFS (queue)
	public int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.pollLast();
				if (cur.left == null && cur.right == null) {
					return depth;
				}
				if (cur.left != null) {
					queue.offerFirst(cur.left);
				}
				if (cur.right != null) {
					queue.offerFirst(cur.right);
				}
			}
		}
		return depth;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
