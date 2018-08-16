import java.util.LinkedList;

// LeetCode #445 (Add Two Numbers II).

// You are given two non-empty linked lists representing two non-negative integers. 

// The most significant digit comes first and each of their nodes contain a single digit. 

// Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example: 
// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7

// Follow up: What if you cannot modify the input lists? In other words, reversing the lists is
// not allowed.

public class AddTwoNumbers2 {

	// Solution 1: reverse --> add --> reverse
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return reverse(add(reverse(l1), reverse(l2)));
	}

	private ListNode add(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), cur = head;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			l1 = (l1 == null) ? l1 : l1.next;
			l2 = (l2 == null) ? l2 : l2.next;
		}
		return head.next;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1), because reverse() is iterative.

	// Solution 2 (follow up): Use stack
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		LinkedList<Integer> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();
		ListNode head1 = l1, head2 = l2;
		while (head1 != null) {
			stack1.offerLast(head1.val);
			head1 = head1.next;
		}
		while (head2 != null) {
			stack2.offerLast(head2.val);
			head2 = head2.next;
		}
		int carry = 0;
		ListNode cur = null;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int sum = (stack1.isEmpty() ? 0 : stack1.pollLast()) + (stack2.isEmpty() ? 0 : stack2.pollLast()) + carry;
			carry = sum / 10;
			ListNode temp = new ListNode(sum % 10);
			temp.next = cur;
			cur = temp;
		}
		return cur;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(m + n).

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}