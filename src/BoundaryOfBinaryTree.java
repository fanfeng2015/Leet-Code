import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #545 (Boundary of Binary Tree).

// The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and 
// the reverse order of the right boundary.

// The left boundary is the set of nodes defined by the following:

// - The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is empty.
// - If a node in the left boundary and has a left child, then the left child is in the left boundary.
// - If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left boundary.
// - The leftmost leaf is not in the left boundary.

// The right boundary is similar to the left boundary, except it is the right side of the root's right subtree. Again, the leaf is
// not part of the right boundary, and the right boundary is empty if the root does not have a right child.

// The leaves are nodes that do not have any children. For this problem, the root is not a leaf.

// Given the root of a binary tree, return the values of its boundary.

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
		if (root.left != null) { // note that this is an else-if statement
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
		if (root.right != null) { // note that this is an else-if statement
			addRightBoundary(root.right, result);
		} else {
			addRightBoundary(root.left, result);
		}
		result.add(root.val);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}