import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// LeetCode #18 (4 Sum).

// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
// Find all unique quadruplets in the array which give the sum of target.

// Note: The solution set must not contain duplicate quadruplets.

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			List<Integer> cur = new ArrayList<>();
			cur.add(nums[i]);
			threeSum(nums, target - nums[i], i + 1, cur, result);
		}
		return result;
	}

	private void threeSum(int[] nums, int target, int begin, List<Integer> cur, List<List<Integer>> result) {
		for (int i = begin; i < nums.length - 2; i++) {
			if (i > begin && nums[i] == nums[i - 1]) {
				continue;
			}
			cur.add(nums[i]);
			twoSum(nums, target - nums[i], i + 1, cur, result);
			cur.remove(cur.size() - 1);
		}
	}

	private void twoSum(int[] nums, int target, int begin, List<Integer> cur, List<List<Integer>> result) {
		int left = begin, right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target && (left == begin || nums[left] != nums[left - 1])) {
				cur.add(nums[left++]);
				cur.add(nums[right--]);
				result.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size() - 1);
				cur.remove(cur.size() - 1);
			} else if (nums[left] + nums[right] <= target) {
				left++;
			} else {
				right--;
			}
		}
	}

	// Time complexity is O(n^3).
	// Space complexity is O(1).
}
