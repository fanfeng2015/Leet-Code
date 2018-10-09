// LeetCode #25 (Reverse Nodes in k-Group).

// Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list.

// k is a positive integer and is less than or equal to the length of the linked 
// list. If the number of nodes is not a multiple of k then left-out nodes in the
// end should remain as it is.

public class ReverseNodesInKGroup {

	// iterative
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0), cur = dummy;
		while (head != null) {
			ListNode tail = head;
			int count = k;
			while (tail != null && count > 1) {
				tail = tail.next;
				count--;
			}
			// tail == null || count == 1
			if (tail == null) { // left-out nodes in the end remain as it is
				cur.next = head;
				return dummy.next;
			}
			ListNode next = tail.next;
			cur.next = reverse(head, tail);
			cur = head;
			head = next;
		}
		return dummy.next;
	}

	// iteratively reverse the partial linked list, from head to tail
	private ListNode reverse(ListNode head, ListNode tail) {
		ListNode left = head, right = tail.next, prev = null, next = null;
		while (left != right) {
			next = left.next;
			left.next = prev;
			prev = left;
			left = next;
		}
		return tail;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// recursive
	public ListNode reverseKGroup2(ListNode head, int k) {
		ListNode cur = head;
		int count = 0;
		while (cur != null && count < k) {
			cur = cur.next;
			count++;
		}
		if (count == k) {
			cur = reverseKGroup2(cur, k);
			while (count > 0) {
				ListNode next = head.next;
				head.next = cur;
				cur = head;
				head = next;
				count--;
			}
			head = cur;
		}
		return head;
	}

	// Time complexity is O(n).
	// Space complexity is O(n/k), because of call-stack.
}
