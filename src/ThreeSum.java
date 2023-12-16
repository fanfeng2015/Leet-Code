import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #15 (3Sum).

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and 
// nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			twoSum(nums, -nums[i], i, i + 1, nums.length - 1, result);
		}
		return result;
	}

	public void twoSum(int[] array, int target, int cur, int left, int right, List<List<Integer>> result) {
		while (left < right) {
			// avoid duplicate triplet
			if (array[left] + array[right] == target && (left - 1 == cur || array[left] != array[left - 1])) {
				result.add(Arrays.asList(array[cur], array[left++], array[right--]));
			} else if (array[left] + array[right] <= target) {
				left++;
			} else {
				right--;
			}
		}
	}

	// Time complexity is O(n^2).
	// Space complexity is O(log(n)), because of quick sort (for primitive types).
}