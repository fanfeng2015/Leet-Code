import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #545 (Boundary of Binary Tree).

// Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. 
// Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

// Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the
// path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the
// root itself is left boundary or right boundary. Note this definition only applies to the input binary tree,
// and not applies to any subtrees.

// The left-most node is defined as a leaf node you could reach when you always firstly travel to the left 
// subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

// The right-most node is also defined by the same way with left and right exchanged.

public class BoundaryOfBinaryTree {

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>(Arrays.asList(new Integer[] { root.val }));
		addLeftBoundary(root.left, result);
		addLeaves(root.left, result);
		addLeaves(root.right, result);
		addRightBoundary(root.right, result);
		return result;
	}

	// add all left boundary nodes except for the leaf node
	private void addLeftBoundary(TreeNode root, List<Integer> result) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		result.add(root.val);
		if (root.left != null) {
			addLeftBoundary(root.left, result);
		} else {
			addLeftBoundary(root.right, result);
		}
	}

	private void addLeaves(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return;
		}
		addLeaves(root.left, result);
		addLeaves(root.right, result);
	}

	// add all right boundary nodes except for the leaf node
	private void addRightBoundary(TreeNode root, List<Integer> result) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		// in reverse order
		if (root.right != null) {
			addRightBoundary(root.right, result);
		} else {
			addRightBoundary(root.left, result);
		}
		result.add(root.val);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when binary tree is highly unbalanced.

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}