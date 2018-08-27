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

}