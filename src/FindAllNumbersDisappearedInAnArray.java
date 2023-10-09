import java.util.ArrayList;
import java.util.List;

// LeetCode #448 (Find All Numbers Disappeared in an Array).

// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the
// integers in the range [1, n] that do not appear in nums.

public class FindAllNumbersDisappearedInAnArray {

	// Solution 1
	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int pos = i, cur = nums[i];
			while (cur != pos + 1) {
				pos = cur - 1;
				int temp = nums[pos];
				nums[pos] = cur;
				cur = temp;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				result.add(i + 1);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Solution 2
	public List<Integer> findDisappearedNumbers2(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1; // 4 should be at index 3
			if (nums[pos] > 0) {
				nums[pos] *= -1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
