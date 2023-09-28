// LeetCode #19 (Remove Nth Node From End of List).

// Given the head of a linked list, remove the nth node from the end of the list and return 
// its head.

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).	
}
