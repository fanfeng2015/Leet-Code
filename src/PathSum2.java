import java.util.ArrayList;
import java.util.List;

// LeetCode #113 (Path Sum II).

// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path
// equals targetSum. Each path should be returned as a list of the node values, not node references.

// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

public class PathSum2 {

	public List<List<Integer>> pathSum(TreeNode root, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		dfs(root, target, new ArrayList<>(), result);
		return result;
	}

	private void dfs(TreeNode root, int target, List<Integer> cur, List<List<Integer>> result) {
		target -= root.val;
		cur.add(root.val);
		if (root.left == null && root.right == null) {
			if (target == 0) {
				result.add(new ArrayList<>(cur));
			}
		}
		if (root.left != null) {
			dfs(root.left, target, cur, result);
		}
		if (root.right != null) {
			dfs(root.right, target, cur, result);
		}
		target += root.val;
		cur.remove(cur.size() - 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}
