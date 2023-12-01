import java.util.LinkedList;

// LeetCode #173 (Binary Search Tree Iterator).

// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
// - BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the
//   constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
// - boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
// - int next() Moves the pointer to the right, then returns the number at the pointer.

// Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest 
// element in the BST.

// You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal 
// when next() is called.

public class BinarySearchTreeIterator {

	LinkedList<TreeNode> stack = new LinkedList<>();

	public BinarySearchTreeIterator(TreeNode root) {
		TreeNode node = root;
		while (node != null) {
			stack.offerLast(node);
			node = node.left;
		}
	}

	public int next() {
		TreeNode node = stack.pollLast();
		TreeNode cur = node.right;
		while (cur != null) {
			stack.offerLast(cur);
			cur = cur.left;
		}
		return node.val;
	}

	public boolean hasNext() {
		return stack.size() > 0;
	}

	// Time complexity is O(1) for hasNext() and O(h) for next().
	// Space complexity is O(h).

	// Follow up (Facebook):
	// 1. Two BSTs.
	// 2. O(1) space -> Morris.

//	TreeNode cur;
//
//	public BinarySearchTreeIterator(TreeNode root) {
//		cur = root;
//	}
//
//	public boolean hasNext() {
//		return cur != null;
//	}
//
//	public int next() {
//		TreeNode temp = null;
//		int result = 0;
//		while (cur != null) {
//			if (cur.left == null) {
//				result = cur.val;
//				cur = cur.right;
//				break; // when next() is called again, while loop continues
//			} else {
//				temp = cur.left;
//				while (temp.right != null && temp.right != cur) {
//					temp = temp.right;
//				}
//				if (temp.right == null) {
//					temp.right = cur;
//					cur = cur.left;
//				} else {
//					result = cur.val;
//					temp.right = null;
//					cur = cur.right;
//					break; // when next() is called again, while loop continues
//				}
//			}
//		}
//		return result;
//	}
}