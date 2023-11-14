import java.util.HashMap;
import java.util.Map;

// LeetCode #437 (Path Sum III).

// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals
// targetSum.

// The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child
// nodes).

public class PathSum3 {

	private int count = 0;

	public int pathSum(TreeNode root, int target) {
		Map<Long, Integer> map = new HashMap<>(); // { sum: frequency }
		map.put(0L, 1);
		dfs(root, target, 0, map);
		return count;
	}

	private void dfs(TreeNode root, int target, long cur, Map<Long, Integer> map) {
		if (root == null) {
			return;
		}
		cur += root.val;
		if (map.containsKey(cur - target)) {
			count += map.get(cur - target);
		}
		int frequency = (map.containsKey(cur) ? map.get(cur) + 1 : 1);
		map.put(cur, frequency);
		dfs(root.left, target, cur, map);
		dfs(root.right, target, cur, map);
		map.put(cur, map.get(cur) - 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
