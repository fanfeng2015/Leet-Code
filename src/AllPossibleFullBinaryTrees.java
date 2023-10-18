import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #894 (All Possible Full Binary Trees).

// Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree
// in the answer must have Node.val == 0.

// Each element of the answer is the root node of one possible tree. You may return the final list of trees
// in any order.

// A full binary tree is a binary tree where each node has exactly 0 or 2 children.

public class AllPossibleFullBinaryTrees {

	Map<Integer, List<TreeNode>> memo = new HashMap<>();

	public List<TreeNode> allPossibleFBT(int n) {
		if (n % 2 == 0) {
			return new ArrayList<TreeNode>();
		}
		if (n == 1) {
			List<TreeNode> result = new ArrayList<>();
			result.add(new TreeNode(0));
			return result;
		}
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		List<TreeNode> result = new ArrayList<>();
		for (int i = 1; 2 * i - 1 < n - 1; i++) {
			List<TreeNode> left = allPossibleFBT(2 * i - 1);
			List<TreeNode> right = allPossibleFBT(n - 2 * i);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(0, l, r);
					result.add(root);
				}
			}
		}
		memo.put(n, result);
		return result;
	}

	// Time complexity is O(2^(n/2)).
	// Space complexity is O(n * 2^(n/2)).
}
