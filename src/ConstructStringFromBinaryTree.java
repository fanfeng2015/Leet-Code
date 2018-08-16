// LeetCode #606 (Construct String from Binary Tree).

// You need to construct a string consists of parenthesis and integers from a 
// binary tree with the pre-order traversing way.

// The null node needs to be represented by empty parenthesis pair "()". And you
// need to omit all the empty parenthesis pairs that don't affect the one-to-one
// mapping relationship between the string and the original binary tree.

public class ConstructStringFromBinaryTree {

	public String tree2str(TreeNode root) {
		return helper(root).toString();
	}

	public StringBuilder helper(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return sb;
		}
		if (root.left == null && root.right == null) {
			sb.append(root.val);
			return sb;
		}
		StringBuilder left = helper(root.left);
		StringBuilder right = helper(root.right);
		return sb.append(root.val).append("(").append(left).append(")")
				.append((right.length() > 0) ? "(" + right + ")" : "");
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}