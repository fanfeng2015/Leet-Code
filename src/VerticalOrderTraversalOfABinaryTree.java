import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// LeetCode #987 (Add Strings).

// Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

// For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) 
// respectively. The root of the tree is at (0, 0).

// The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost
// column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these
// nodes by their values.

// Return the vertical order traversal of the binary tree.

public class VerticalOrderTraversalOfABinaryTree {

	private class Point implements Comparable<Point> {
		int row, col, val;

		Point(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}

		@Override
		public int compareTo(Point other) {
			if (this.col != other.col) {
				return this.col < other.col ? -1 : 1;
			} else if (this.row != other.row) {
				return this.row < other.row ? -1 : 1;
			} else {
				return this.val < other.val ? -1 : 1;
			}
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		int min = 0, max = 0, row = 0;
		Map<Integer, ArrayList<Point>> map = new HashMap<>(); // { col: [] }
		LinkedList<Integer> colQueue = new LinkedList<>();
		LinkedList<TreeNode> nodeQueue = new LinkedList<>();
		colQueue.offerFirst(0);
		nodeQueue.offerFirst(root);
		while (!colQueue.isEmpty()) {
			int size = colQueue.size();
			for (int i = 0; i < size; i++) {
				int col = colQueue.pollLast();
				TreeNode node = nodeQueue.pollLast();
				map.putIfAbsent(col, new ArrayList<Point>());
				map.get(col).add(new Point(row, col, node.val));
				if (node.left != null) {
					min = Math.min(min, col - 1);
					colQueue.offerFirst(col - 1);
					nodeQueue.offerFirst(node.left);
				}
				if (node.right != null) {
					max = Math.max(max, col + 1);
					colQueue.offerFirst(col + 1);
					nodeQueue.offerFirst(node.right);
				}
			}
			row++;
		}
		for (int i = min; i <= max; i++) {
			Collections.sort(map.get(i));
			ArrayList<Integer> list = new ArrayList<>();
			for (Point p : map.get(i)) {
				list.add(p.val);
			}
			result.add(list);
		}
		return result;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}
