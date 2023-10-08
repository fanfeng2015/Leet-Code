import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// LeetCode #1676 (Lowest Common Ancestor of a Binary Tree IV).

// Given the root of a binary tree and an array of TreeNode objects nodes, return the lowest 
// common ancestor (LCA) of all the nodes in nodes. All the nodes will exist in the tree, and 
// all values of the tree's nodes are unique.

public class LowestCommonAncestorOfABinaryTree4 {

	// Assumptions:
	// 1. nodes[i] != nodes[j], for any i != j.
	// 2. All nodes of the tree have unique values.
	// 3. The list of nodes are guaranteed to be in the binary tree.	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		return lowestCommonAncestor(root, new HashSet<>(Arrays.asList(nodes)));
	}

	private TreeNode lowestCommonAncestor(TreeNode root, Set<TreeNode> set) {
		if (root == null || set.contains(root)) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, set);
		TreeNode right = lowestCommonAncestor(root.right, set);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
}
