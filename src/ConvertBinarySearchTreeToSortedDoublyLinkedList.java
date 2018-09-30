// LeetCode #426 (Convert Binary Search Tree to Sorted Doubly Linked List).

// Convert a BST to a sorted circular doubly-linked list in-place. Think of the left
// and right pointers as synonymous to the previous and next pointers in a doubly-linked 
// list.

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

	// recursive in-order
	TreeNode prev = null;

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode head = new TreeNode(0);
		prev = head;
		inorder(root);
		// connect head and tail
		prev.right = head.right;
		head.right.left = prev;
		return head.right;
	}

	// Converts the BST rooted at cur to a doubly linked list. Updates prev along
	// the way.
	private void inorder(TreeNode cur) {
		if (cur == null) {
			return;
		}
		inorder(cur.left);
		prev.right = cur;
		cur.left = prev;
		prev = cur;
		inorder(cur.right);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
