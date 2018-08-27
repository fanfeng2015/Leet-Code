// LeetCode #203 (Remove Linked List Elements).

// Remove all elements from a linked list of integers that have value val.

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
