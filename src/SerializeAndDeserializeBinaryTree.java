import java.util.Arrays;
import java.util.LinkedList;

// LeetCode #297 (Serialize and Deserialize Binary Tree).
// LeetCode #449 (Serialize and Deserialize BST).

// Serialization is the process of converting a data structure or object into a sequence of bits
// so that it can be stored in a file or memory buffer, or transmitted across a network connection
// link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
// your serialization/deserialization algorithm should work. You just need to ensure that a binary
// tree can be serialized to a string and this string can be deserialized to the original tree 
// structure.

public class SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private StringBuilder serialize(TreeNode node, StringBuilder sb) {
		if (node == null) {
			return sb.append("#");
		}
		sb.append(node.val).append(",");
		serialize(node.left, sb).append(",");
		serialize(node.right, sb);
		return sb;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
	}

	private TreeNode deserialize(LinkedList<String> strs) {
		String s = strs.pollFirst();
		if (s.equals("#")) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(s));
		node.left = deserialize(strs);
		node.right = deserialize(strs);
		return node;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

//       1
//      / \
//     2   3
//        / \
//       4   5

// 1,2,#,#,3,4,#,#,5,#,#
