import java.util.LinkedList;

// LeetCode #116 (Populating Next Right Pointers in Each Node).

// Given a binary tree, populate each next pointer to point to its next right node. 

// If there is no next right node, the next pointer should be set to null.

// Initially, all next pointers are set to null.

// Notes:
// 1. You may only use constant extra space.
// 2. Recursive approach is fine, implicit stack space does not count as extra space 
//    for this problem.
// 3. You may assume that it is a perfect binary tree (i.e., all leaves are at the 
//    same level, and every parent has two children).

public class PopulatingNextRightPointerInEachNode {

	// Solution 1: BFS
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeLinkNode> queue = new LinkedList<>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode cur = queue.pollLast();
				cur.next = (i == size - 1) ? null : queue.peekLast();
				if (cur.left != null) {
					queue.offerFirst(cur.left);
				}
				if (cur.right != null) {
					queue.offerFirst(cur.right);
				}
			}
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: in place
	public void connect2(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode prev = root, cur = null;
		while (prev.left != null) {
			cur = prev;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			prev = prev.left; // next level
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
