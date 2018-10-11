// LeetCode #117 (Populating Next Right Pointers in Each Node II).

// What if the given tree could be any binary tree?
// You may only use constant extra space.

public class PopulatingNextRightPointerInEachNode2 {

	// Solution 1: BFS (see LeetCode #116).

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: in place
	public void connect(TreeLinkNode root) {
		TreeLinkNode head = root;
		while (head != null) {
			TreeLinkNode nextHead = new TreeLinkNode(0), nextTail = nextHead;
			while (head != null) { // current level
				if (head.left != null) {
					nextTail.next = head.left;
					nextTail = nextTail.next;
				}
				if (head.right != null) {
					nextTail.next = head.right;
					nextTail = nextTail.next;
				}
				head = head.next;
			}
			head = nextHead.next; // next level
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
