import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #103 (Binary Tree Zigzag Level Order Traversal).

// Given the root of a binary tree, return the zigzag level order traversal of its nodes' 
// values. (i.e., from left to right, then right to left for the next level and alternate 
// between).

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		int level = 0;
		queue.offerFirst(root);
		while (queue.size() > 0) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if (level % 2 == 0) {
					TreeNode cur = queue.pollLast();
					list.add(cur.val);
					if (cur.left != null) {
						queue.offerFirst(cur.left);
					}
					if (cur.right != null) {
						queue.offerFirst(cur.right);
					}
				} else {
					TreeNode cur = queue.pollFirst();
					list.add(cur.val);
					if (cur.right != null) {
						queue.offerLast(cur.right);
					}
					if (cur.left != null) {
						queue.offerLast(cur.left);
					}
				}
			}
			level++;
			result.add(list);
		}
		return result;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n).	
}

//        3
//      /   \
//     9     20
//    / \    / \
//   10 11  15  7

// [3], level = 0, pollLast(), offerFirst(), left child first
// [20, 9], level = 1, pollFirst(), offerLast(), right child first
// [7, 15, 11, 10]
