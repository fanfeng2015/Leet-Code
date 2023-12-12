// LeetCode #708 (Insert into a Sorted Circular Linked List).

// Given a Circular Linked List node, which is sorted in non-descending order, write a function to insert a value insertVal into the
// list such that it remains a sorted circular list. The given node can be a reference to any single node in the list and may not 
// necessarily be the smallest value in the circular list.

// If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the 
// circular list should remain sorted.

// If the list is empty (i.e., the given node is null), you should create a new single circular list and return the reference to that
// single node. Otherwise, you should return the originally given node.

public class InsertIntoASortedCircularLinkedList {

	private class Node {
		public int val;
		public Node next;

		public Node(int _val) {
			val = _val;
		}
	};

	public Node insert(Node head, int insertVal) {
		if (head == null) {
			head = new Node(insertVal);
			head.next = head;
			return head;
		}
		Node node = head;
		while (node.next != head) {
			Node next = node.next;
			if (node.val <= next.val) {
				if (node.val <= insertVal && insertVal <= next.val) {
					break; // insert after node
				}
			} else {
				if (node.val <= insertVal || insertVal <= next.val) {
					break;
				}
			}
			node = node.next;
		}
		Node temp = new Node(insertVal);
		temp.next = node.next;
		node.next = temp;
		return head;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
