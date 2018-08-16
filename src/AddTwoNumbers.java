// LeetCode #2 (Add Two Numbers).

// You are given two non-empty linked lists representing two non-negative integers.

// The digits are stored in reverse order and each of their nodes contains a single digit. 

// Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), cur = head;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			cur.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = (l1 == null) ? l1 : l1.next;
			l2 = (l2 == null) ? l2 : l2.next;
			cur = cur.next;
		}
		return head.next;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}