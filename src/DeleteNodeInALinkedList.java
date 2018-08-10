// LeetCode #237 (Delete Node in Linked List).

// Write a function to delete a node (except the tail) in a singly linked list, 
// given only access to that node.

public class DeleteNodeInALinkedList {

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	// Meaningless question...

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
