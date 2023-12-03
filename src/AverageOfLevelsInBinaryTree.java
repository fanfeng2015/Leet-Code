import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #637 (Average of Levels in Binary Tree).

// Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5
// of the actual answer will be accepted.

public class AverageOfLevelsInBinaryTree {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerLast(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0.0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pollFirst();
				sum += node.val;
				if (node.left != null) {
					queue.offerLast(node.left);
				}
				if (node.right != null) {
					queue.offerLast(node.right);
				}
			}
			result.add(sum / size);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
