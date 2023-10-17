// LeetCode #109 (Convert Sorted List to Binary Search Tree).

// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
// height-balanced binary search tree.

public class ConvertSortedListToBST {

	public TreeNode sortedListToBST(ListNode head) {
		return convert(head, null);
	}

	private TreeNode convert(ListNode head, ListNode tail) {
		if (head == tail) {
			return null;
		}
		ListNode slow = head, fast = head;
		// find middle node
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = convert(head, slow);
		root.right = convert(slow.next, tail);
		return root;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(log(n)).
}
