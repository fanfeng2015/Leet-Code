import java.util.LinkedList;
import java.util.List;

// LeetCode #515 (Find Largest Value in Each Tree Row).

// Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

public class FindLargestValueInEachTreeRow {

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			int max = Integer.MIN_VALUE;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pollLast();
				max = Math.max(max, node.val);
				if (node.left != null) {
					queue.offerFirst(node.left);
				}
				if (node.right != null) {
					queue.offerFirst(node.right);
				}
			}
			result.add(max);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
