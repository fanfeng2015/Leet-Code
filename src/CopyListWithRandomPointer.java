import java.util.HashMap;
import java.util.Map;

// LeetCode #138 (Copy List with Random Pointer).

// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in
// the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value
// set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes 
// in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers
// in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x 
// and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index]
// where:
// - val: an integer representing Node.val
// - random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any
//   node.

// Your code will only be given the head of the original linked list.

public class CopyListWithRandomPointer {

	private class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Map<Node, Node> lookUp = new HashMap<>();
		Node newHead = new Node(head.val);
		Node cur = newHead;
		lookUp.put(head, newHead);
		while (head != null) {
			if (head.next != null) {
				if (!lookUp.containsKey(head.next)) {
					Node node = new Node(head.next.val);
					lookUp.put(head.next, node);
				}
				cur.next = lookUp.get(head.next);
			}
			if (head.random != null) {
				if (!lookUp.containsKey(head.random)) {
					Node node = new Node(head.random.val);
					lookUp.put(head.random, node);
				}
				cur.random = lookUp.get(head.random);
			}
			head = head.next;
			cur = cur.next;
		}
		return newHead;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Follow up: Use O(1) space?
	public Node copyRandomList2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		while (cur != null) {
			Node node = cur.next;
			Node newNext = new Node(cur.val);
			cur.next = newNext;
			newNext.next = node;
			cur = cur.next.next;
		}
		cur = head;
		while (cur != null) {
			cur.next.random = (cur.random == null) ? null : cur.random.next;
			cur = cur.next.next;
		}
		cur = head;
		Node newHead = head.next;
		while (cur != null) {
			Node prev = cur.next.next; // possibly null
			cur.next.next = (prev == null) ? null : prev.next;
			cur.next = prev;
			cur = cur.next;
		}
		return newHead;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
