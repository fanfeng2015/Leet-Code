import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #652 (Find Duplicate Subtrees).

// Given the root of a binary tree, return all duplicate subtrees.

// For each kind of duplicate subtrees, you only need to return the root node of any one of them.

// Two trees are duplicate if they have the same structure with the same node values.

public class FindDuplicateSubtrees {

	// -------------------- 2023 TikTok Phone Interview --------------------
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		dfs(root, new HashMap<>(), result);
		return result;
	}

	private StringBuilder dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
		if (node == null) {
			return new StringBuilder("#");
		}
		StringBuilder left = dfs(node.left, map, result);
		StringBuilder right = dfs(node.right, map, result);

		StringBuilder sb = left.append(',').append(right).append(',').append(node.val);
		String str = sb.toString();
		map.put(str, map.getOrDefault(str, 0) + 1);
		if (map.get(str) == 2) {
			result.add(node);
		}
		return sb;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).

	int global = 0;
	Map<String, Integer> strToId = new HashMap<>();
	Map<Integer, Integer> idToCount = new HashMap<>();

	public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		dfs2(root, result);
		return result;
	}

	private int dfs2(TreeNode node, List<TreeNode> result) {
		if (node == null) {
			return 0;
		}
		int left = dfs2(node.left, result);
		int right = dfs2(node.right, result);
		String str = left + "," + right + "," + node.val; // in-order would be okay here
		strToId.putIfAbsent(str, ++global);
		int id = strToId.get(str);
		idToCount.put(id, idToCount.getOrDefault(id, 0) + 1);
		if (idToCount.get(id) == 2) {
			result.add(node);
		}
		return id;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

// can use either pre-order or post-order, but in-order would generate the same serialization for symmetric trees

//     0
//    / \
//   0   #
//  / \
// #   #

//     0
//    / \
//   #   0
//      / \
//     #   #
