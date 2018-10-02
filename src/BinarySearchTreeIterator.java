import java.util.LinkedList;

// LeetCode #173 (Binary Search Tree Iterator).

// Implement an iterator over a binary search tree (BST). Your iterator will be initialized
// with the root node of a BST.

// Calling next() will return the next smallest number in the BST.

// Note: 
// next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the
// height of the tree.

public class BinarySearchTreeIterator {

	TreeNode cur;
	LinkedList<TreeNode> stack;

	public BinarySearchTreeIterator(TreeNode root) {
		cur = root;
		stack = new LinkedList<TreeNode>();
		while (cur != null) {
			stack.offerLast(cur);
			cur = cur.left;
		}
	}

	public boolean hasNext() {
		return stack.size() > 0;
	}

	public int next() {
		int result = stack.peekLast().val;
		cur = stack.pollLast();
		cur = cur.right;
		while (cur != null) {
			stack.offerLast(cur);
			cur = cur.left;
		}
		return result;
	}

	// Time complexity is O(1) for hasNext() and O(h) for next().
	// Space complexity is O(h).

	// Follow up (Facebook):
	// 1. Two BSTs.
	// 2. O(1) space -> Morris.
	
/*
	public BinarySearchTreeIterator(TreeNode root) {
		cur = root;
	}

	public boolean hasNext() {
		return cur != null;
	}

	public int next() {
		TreeNode temp = null;
		int result = 0;
		while (cur != null) {
			if (cur.left == null) {
				result = cur.val;
				cur = cur.right;
				break; // when next() is called again, while loop continues
			} else {
				temp = cur.left;
				while (temp.right != null && temp.right != cur) {
					temp = temp.right;
				}
				if (temp.right == null) {
					temp.right = cur;
					cur = cur.left;
				} else {
					result = cur.val;
					temp.right = null;
					cur = cur.right;
					break; // when next() is called again, while loop continues
				}
			}
		}
		return result;
	}
*/

}