import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// LeetCode #863 (All Nodes Distance K in Binary Tree).

// Given the root of a binary tree, the value of a target node target, and an integer k, return an 
// array of the values of all nodes that have a distance k from the target node.

// You can return the answer in any order.

public class AllNodesDistanceKInBinaryTree {

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pollLast();
				if (node.left != null) {
					parent.put(node.left, node);
					queue.offerFirst(node.left);
				}
				if (node.right != null) {
					parent.put(node.right, node);
					queue.offerFirst(node.right);
				}
			}
		}
		Set<TreeNode> set = new HashSet<>();
		set.add(target);
		queue.offerFirst(target);
		for (int i = 0; i < k && !queue.isEmpty(); i++) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				TreeNode node = queue.pollLast();
				if (parent.containsKey(node) && set.add(parent.get(node))) {
					queue.offerFirst(parent.get(node));
				}
				if (node.left != null && set.add(node.left)) {
					queue.offerFirst(node.left);
				}
				if (node.right != null && set.add(node.right)) {
					queue.offerFirst(node.right);
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		for (TreeNode node : queue) {
			result.add(node.val);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
