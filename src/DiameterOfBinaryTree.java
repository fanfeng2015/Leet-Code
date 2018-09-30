import java.util.ArrayList;
import java.util.List;

// LeetCode #543 (Diameter of Binary Tree).

// Given a binary tree, you need to compute the length of the diameter of the tree. 
// The diameter of a binary tree is the length of the longest path between any two 
// nodes in a tree. This path may or may not pass through the root.

public class DiameterOfBinaryTree {

	private int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return max;
	}

	// Returns the length of the longest path that starts from the root node.
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

/*	
	// Follow up (Facebook): Print the longest path.
	private List<Integer> longest = new ArrayList<>();

	public List<Integer> longestPathOfBinaryTree(TreeNode root) {
		longest(root);
		return longest;
	}

	// Returns the longest path that starts from the root node.
	private List<Integer> longest(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> left = longest(root.left);
		List<Integer> right = longest(root.right);
		if (left.size() + right.size() > longest.size()) {
			longest = new ArrayList<>(left);
			longest.add(root.val);
			longest.addAll(reverse(right));
		}
		List<Integer> longer = (left.size() < right.size()) ? right : left;
		longer.add(root.val);
		return longer;
	}

	private List<Integer> reverse(List<Integer> list) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(list.size() - 1 - i));
		}
		return result;
	}
*/

}
