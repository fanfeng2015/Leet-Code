// import java.util.ArrayList;
// import java.util.List;

// LeetCode #543 (Diameter of Binary Tree).

// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may
// not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

public class DiameterOfBinaryTree {

	private int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		longestFromNode(root);
		return max;
	}

	private int longestFromNode(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = longestFromNode(node.left);
		int right = longestFromNode(node.right);
		max = Math.max(max, left + right);
		return 1 + Math.max(left, right);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

//	Follow up (Facebook): Print the longest path.
//	private List<Integer> longest = new ArrayList<>();
//
//	public List<Integer> longestPathOfBinaryTree(TreeNode root) {
//		longest(root);
//		return longest;
//	}
//
//	// Returns the longest path that starts from the root node.
//	private List<Integer> longest(TreeNode root) {
//		if (root == null) {
//			return new ArrayList<>();
//		}
//		List<Integer> left = longest(root.left);
//		List<Integer> right = longest(root.right);
//		if (left.size() + right.size() > longest.size()) {
//			longest = new ArrayList<>(left);
//			longest.add(root.val);
//			longest.addAll(reverse(right));
//		}
//		List<Integer> longer = (left.size() < right.size()) ? right : left;
//		longer.add(root.val);
//		return longer;
//	}
//
//	private List<Integer> reverse(List<Integer> list) {
//		List<Integer> result = new ArrayList<>();
//		for (int i = 0; i < list.size(); i++) {
//			result.add(list.get(list.size() - 1 - i));
//		}
//		return result;
//	}
}
