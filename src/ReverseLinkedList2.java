// LeetCode #92 (Reverse Linked List II).

// Given the head of a singly linked list and two integers left and right where left <= right, 
// reverse the nodes of the list from position left to position right, and return the reversed 
// list.

public class ReverseLinkedList2 {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy, temp = dummy;
		for (int i = 0; i < left; i++) {
			temp = cur;
			cur = cur.next;
		}
		ListNode prev = null, next = null;
		for (int i = left; i <= right; i++) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		if (temp != null) {
			if (temp.next != null) {
				temp.next.next = cur;
			}
			temp.next = prev;
		}
		return dummy.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

// 0 -> 1 -> 2 <- 3 <- 4 -> 5
// d
//                     p    c    n
//      t   
