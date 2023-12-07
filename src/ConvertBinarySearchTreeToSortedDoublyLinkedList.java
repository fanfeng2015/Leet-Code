// LeetCode #426 (Convert Binary Search Tree to Sorted Doubly Linked List).

// Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

// You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. 
// For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element
// is the first element.

// We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its 
// predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the
// linked list.

import java.util.LinkedList;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

	private class Node {
		@SuppressWarnings("unused")
		public int val;
		public Node left;
		public Node right;

		public Node(int val) {
			this.val = val;
		}
	};

	// iterative
	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		Node node = root, prev = null, head = null;
		LinkedList<Node> stack = new LinkedList<>();
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.offerLast(node);
				node = node.left;
			} else {
				if (prev == null) {
					head = stack.peekLast();
				}
				node = stack.pollLast();
				if (prev != null) {
					prev.right = node;
					node.left = prev;
				}
				prev = node;
				node = node.right;
			}
		}
		prev.right = head; // prev is the last node
		head.left = prev;
		return head;
	}

	// Time complexity is O(n).
	// Space complexity is O(n) in the worst case (left-scewed linked list), but
	// O(log(n)) in the average case.

	// recursive in-order
	Node prev = null;

	public Node treeToDoublyList2(Node root) {
		if (root == null) {
			return null;
		}
		Node head = new Node(0);
		prev = head;
		inorder(root); // after this, head is head and prev is tail
		prev.right = head.right;
		head.right.left = prev;
		return head.right;
	}

	// Converts the BST rooted at cur to a doubly linked list.
	// Updates prev along the way.
	private void inorder(Node cur) {
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
	// Space complexity is O(n) in the worst case, but O(log(n)) in the average
	// case.
}
