// LeetCode #234 (Palindrome Linked List).

// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

public class PalindromeLinkedList {

	private ListNode node; // pointer to node in the first half

	public boolean isPalindrome(ListNode head) {
		node = head;
		return recursive(head);
	}

	// cur is a pointer to node in the second half, in reverse order
	private boolean recursive(ListNode cur) {
		if (cur == null) {
			return true;
		}
		if (!recursive(cur.next)) {
			return false;
		} else if (cur.val != node.val) {
			return false;
		}
		node = node.next;
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public boolean isPalindrome2(ListNode head) {
		ListNode slow = head, fast = head;
		// find the start of the second half, and assign to slow
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		// reverse the second half
		ListNode prev = null, next = null;
		while (slow != null) {
			next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}
		// compare the two halves
		while (prev != null) {
			if (head.val != prev.val) {
				return false;
			} else {
				head = head.next;
				prev = prev.next;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
