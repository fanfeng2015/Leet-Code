import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

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
		Map<Integer, ArrayList<Integer>> map = new HashMap<>(); // { col: [] }
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

	private int min = 0, max = 0;

	// DFS
	public List<List<Integer>> verticalOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Map<Integer, ArrayList<Pair<Integer, Integer>>> map = new HashMap<>(); // { col: [(row, val)] }
		dfs(root, 0, 0, map);
		for (int i = min; i <= max; i++) {
			ArrayList<Pair<Integer, Integer>> list = map.get(i);
			Collections.sort(list, (a, b) -> (a.getKey() - b.getKey()));
			ArrayList<Integer> cur = new ArrayList<>();
			for (Pair<Integer, Integer> pair : list) {
				cur.add(pair.getValue());
			}
			result.add(cur);
		}
		return result;
	}

	private void dfs(TreeNode root, int row, int col, Map<Integer, ArrayList<Pair<Integer, Integer>>> map) {
		if (root == null) {
			return;
		}
		min = Math.min(min, col);
		max = Math.max(max, col);
		map.putIfAbsent(col, new ArrayList<Pair<Integer, Integer>>());
		map.get(col).add(new Pair<Integer, Integer>(row, root.val));
		dfs(root.left, row + 1, col - 1, map);
		dfs(root.right, row + 1, col + 1, map);
	}

	// Time complexity is O(n + c*r*log(r)).
	// Space complexity is O(n).
}
