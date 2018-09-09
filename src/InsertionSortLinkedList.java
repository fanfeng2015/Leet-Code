// LeetCode #147 (Insertion Sort List).

// Sort a linked list using insertion sort.

public class InsertionSortLinkedList {

	public ListNode insertionSortList(ListNode head) {
		for (ListNode cur = head; cur != null; cur = cur.next) {
			ListNode min = cur;
			for (ListNode iter = min.next; iter != null; iter = iter.next) {
				if (iter.val < min.val) {
					min = iter;
				}
			}
			// swap
			int temp = cur.val;
			cur.val = min.val;
			min.val = temp;
		}
		return head;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).
}
