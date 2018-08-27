import java.util.LinkedList;

// LeetCode #230 (Kth Smallest Element in a BST).

// Given a binary search tree, write a function kthSmallest to find the kth 
// smallest element in it.

// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

public class KthSmallestElementInABST {

	private int count = 0;
	private int result = 0;

	// recursive in-order
	public int kthSmallest(TreeNode root, int k) {
		inOrder(root, k);
		return result;
	}

	private void inOrder(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		inOrder(root.left, k);
		count++;
		if (count == k) {
			result = root.val;
			return;
		}
		inOrder(root.right, k);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.

	// iterative in-order
	public int kthSmallest2(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || stack.size() != 0) {
			if (cur != null) {
				stack.offerLast(cur);
				cur = cur.left;
			} else {
				cur = stack.pollLast();
				k--;
				if (k == 0) {
					return cur.val;
				}
				cur = cur.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
