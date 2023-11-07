import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// LeetCode #314 (Binary Tree Vertical Order Traversal).

// Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by
// column).

// If two nodes are in the same row and column, the order should be from left to right.

public class BinaryTreeVerticalrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		int min = 0, max = 0;
		Map<Integer, ArrayList<Integer>> map = new HashMap<>(); // { index: [] }
		LinkedList<Integer> indexQueue = new LinkedList<>();
		LinkedList<TreeNode> nodeQueue = new LinkedList<>();
		indexQueue.offerFirst(0);
		nodeQueue.offerFirst(root);
		while (!indexQueue.isEmpty()) {
			int index = indexQueue.pollLast();
			TreeNode node = nodeQueue.pollLast();
			map.putIfAbsent(index, new ArrayList<Integer>());
			map.get(index).add(node.val);
			if (node.left != null) {
				min = Math.min(min, index - 1);
				indexQueue.offerFirst(index - 1);
				nodeQueue.offerFirst(node.left);
			}
			if (node.right != null) {
				max = Math.max(max, index + 1);
				indexQueue.offerFirst(index + 1);
				nodeQueue.offerFirst(node.right);
			}
		}
		for (int i = min; i <= max; i++) {
			result.add(map.get(i));
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
