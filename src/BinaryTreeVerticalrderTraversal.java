import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// LeetCode #314 (Binary Tree Vertical Order Traversal).

// Given a binary tree, return the vertical order traversal of its nodes' values. (ie, 
// from top to bottom, column by column).

// If two nodes are in the same row and column, the order should be from left to right.

public class BinaryTreeVerticalrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		int min = 0, max = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		LinkedList<TreeNode> nodeQueue = new LinkedList<>();
		LinkedList<Integer> indexQueue = new LinkedList<>();
		nodeQueue.offerFirst(root);
		indexQueue.offerFirst(0);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.pollLast();
			Integer index = indexQueue.pollLast();
			if (!map.containsKey(index)) {
				map.put(index, new ArrayList<>());
			}
			map.get(index).add(node.val);
			if (node.left != null) {
				nodeQueue.offerFirst(node.left);
				indexQueue.offerFirst(index - 1);
				min = Math.min(min, index - 1);
			}
			if (node.right != null) {
				nodeQueue.offerFirst(node.right);
				indexQueue.offerFirst(index + 1);
				max = Math.max(max, index + 1);
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
