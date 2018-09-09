// LeetCode #160 (Intersection of Two Linked Lists).

// Write a program to find the node at which the intersection of two singly linked lists begins.

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode curA = headA;
		ListNode curB = headB;
		while (curA != curB) {
			curA = curA == null ? headB : curA.next;
			curB = curB == null ? headA : curB.next;
		}
		return curA;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).
}
