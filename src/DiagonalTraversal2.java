import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #1424 (Diagonal Traverse II).

// Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below
// images.

public class DiagonalTraversal2 {

	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		int count = 0;
		for (List<Integer> list : nums) {
			count += list.size();
		}
		int index = 0;
		int[] result = new int[count];
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j <= i; j++) {
				int row = i - j, col = j;
				if (col < nums.get(row).size()) {
					result[index++] = nums.get(row).get(col);
				}
				if (index == count) {
					return result;
				}
			}
		}
		for (int i = nums.size(); index < count; i++) {
			for (int j = nums.size() - 1; j >= 0; j--) {
				int row = j, col = i - j;
				if (col < nums.get(row).size()) {
					result[index++] = nums.get(row).get(col);
				}
				if (index == count) {
					return result;
				}
			}
		}
		return null; // shouldn't reach here
	}

	// Time complexity is O(m*n), where m is the number of elements in the longest
	// row and n is the number of elements in the longest column.
	// Space complexity is O(1).

	public int[] findDiagonalOrder2(List<List<Integer>> nums) {
		int count = 0, index = 0;
		List<LinkedList<Integer>> stacks = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < nums.get(i).size(); j++) {
				count++;
				int group = i + j;
				if (group >= stacks.size()) {
					stacks.add(new LinkedList<>());
				}
				stacks.get(group).offerFirst(nums.get(i).get(j));
			}
		}
		int[] result = new int[count];
		for (List<Integer> stack : stacks) {
			for (Integer val : stack) {
				result[index++] = val;
			}
		}
		return result;
	}

	// Time complexity is O(t), where t is the total number of elements.
	// Space complexity is O(t).
}
