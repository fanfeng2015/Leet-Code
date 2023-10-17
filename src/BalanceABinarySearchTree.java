import java.util.ArrayList;
import java.util.List;

// LeetCode #1382 (Balance a Binary Search Tree).

// Given the root of a binary search tree, return a balanced binary search tree with the same node values. 
// If there is more than one answer, return any of them.

// A binary search tree is balanced if the depth of the two subtrees of every node never differs by more 
// than 1.

public class BalanceABinarySearchTree {

	public TreeNode balanceBST(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		inorderTraversal(root, list);
		return convertListToBST(list, 0, list.size() - 1);
	}

	private void inorderTraversal(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, list);
		list.add(root);
		inorderTraversal(root.right, list);
	}

	private TreeNode convertListToBST(List<TreeNode> list, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode root = list.get(mid);
		root.left = convertListToBST(list, left, mid - 1);
		root.right = convertListToBST(list, mid + 1, right);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
