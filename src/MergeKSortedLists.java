import java.util.PriorityQueue;

// LeetCode #23 (Merge k Sorted Lists).

// Merge k sorted linked lists and return it as one sorted list. 
// Analyze and describe its complexity.

public class MergeKSortedLists {

	// Solution 1: BFS + Heap
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		int k = lists.length;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, (a, b) -> (a.val - b.val));
		for (ListNode head : lists) {
			if (head != null) {
				minHeap.offer(head);
			}
		}
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.poll();
			cur.next = node;
			cur = cur.next;
			if (node.next != null) {
				minHeap.offer(node.next);
			}
		}
		return newHead.next;
	}

	// n = number of lists, k = length of list
	// Time complexity is O(n*k*log(n)).
	// Space complexity is O(n).

	// Solution 2: Binary Reduction
	// Time complexity is O(n*k*log(n)).
	// Space complexity is O(n*k).

	// When array sizes are big, solution 1 reads and writes each element once,
	// while solution 2 reads and writes reach element log(k) times.
}
