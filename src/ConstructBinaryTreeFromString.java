// LeetCode #536 (Construct Binary Tree from String).

// You need to construct a binary tree from a string consisting of parenthesis and integers.

// The whole input represents a binary tree. It contains an integer followed by zero, one or
// two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis
// contains a child binary tree with the same structure.

// You always start to construct the left child node of the parent first if it exists.

public class ConstructBinaryTreeFromString {

	public TreeNode str2tree(String s) {
		return str2tree(s, 0, s.length() - 1);
	}

	private TreeNode str2tree(String s, int left, int right) {
		if (left > right) {
			return null;
		}
		int cur = left;
		while (cur <= right && s.charAt(cur) != '(') {
			cur++;
		}
		TreeNode root = new TreeNode(Integer.parseInt(s.substring(left, cur)));
		if (cur <= right) {
			int count = 1; // count of '('
			int prev = cur++;
			while (cur <= right) {
				count = (s.charAt(cur) == '(') ? count + 1 : (s.charAt(cur) == ')') ? count - 1 : count;
				if (count == 0) {
					break;
				}
				cur++;
			}
			root.left = str2tree(s, prev + 1, cur - 1);
			root.right = str2tree(s, cur + 2, right - 1);
		}
		return root;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).
}
