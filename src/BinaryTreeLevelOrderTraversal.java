import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #102 (Binary Tree Level Order Traversal).

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from
// left to right, level by level).

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerLast(root);
		while (!queue.isEmpty()) {
			List<Integer> curLevel = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.pollFirst();
				curLevel.add(cur.val);
				if (cur.left != null) {
					queue.offerLast(cur.left);
				}
				if (cur.right != null) {
					queue.offerLast(cur.right);
				}
			}
			result.add(curLevel);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O().
}
