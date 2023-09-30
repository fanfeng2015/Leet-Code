// LeetCode #21 (Merge Two Sorted Lists).

// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the
// nodes of the first two lists.

// Return the head of the merged linked list.

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }
	
	// Time complexity is O(m+n).
	// Space complexity is O(1).   
}
