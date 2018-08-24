import java.util.LinkedList;
import java.util.Queue;

// LeetCode #513 (Find Bottom Left Tree Value).

// Given a binary tree, find the leftmost value in the last row of the tree.

public class FindBottomLeftTreeValue {

	public int findBottomLeftValue(TreeNode root) {
		int result = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			result = queue.peek().val;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
}
