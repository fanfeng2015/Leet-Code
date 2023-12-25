import java.util.List;

// LeetCode #1522 (Diameter of N-Ary Tree).

// Given a root of an N-ary tree, you need to compute the length of the diameter of the tree.

// The diameter of an N-ary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass
// through the root.

// (Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null 
// value.)

public class DiameterOfNAryTree {

	class Node {
		public int val;
		public List<Node> children;
	}

	private int max = 0;

	public int diameter(Node root) {
		dfs(root);
		return max;
	}

	private int dfs(Node node) {
		if (node == null) {
			return 0;
		}
		int largest = 0, secondLargest = 0;
		for (Node child : node.children) {
			int length = dfs(child);
			if (length > largest) {
				secondLargest = largest;
				largest = length;
			} else if (length > secondLargest) {
				secondLargest = length;
			}
		}
		max = Math.max(max, largest + secondLargest);
		return largest + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
