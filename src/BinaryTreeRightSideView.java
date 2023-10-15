import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #199 (Binary Tree Right Side View).

// Given the root of a binary tree, imagine yourself standing on the right side of it, return the 
// values of the nodes you can see ordered from top to bottom.

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pollLast();
				if (i == size - 1) {
					result.add(node.val);
				}
				if (node.left != null) {
					queue.offerFirst(node.left);
				}
				if (node.right != null) {
					queue.offerFirst(node.right);
				}
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
