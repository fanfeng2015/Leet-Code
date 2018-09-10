import java.util.LinkedList;

// LeetCode #226 (Invert Binary Tree).

// Invert a binary tree.

public class InvertBinaryTree {

	// recursive
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// iterative
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return root;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.pollLast();
			// swap left and right
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if (node.left != null) {
				queue.offerFirst(node.left);
			}
			if (node.right != null) {
				queue.offerFirst(node.right);
			}
		}
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
