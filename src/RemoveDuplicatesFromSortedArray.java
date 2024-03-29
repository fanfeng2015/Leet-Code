import java.util.HashSet;
import java.util.Set;

// LeetCode #26 (Remove Duplicates from Sorted Array).

// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
// such that each unique element appears only once. The relative order of the elements should
// be kept the same. Then return the number of unique elements in nums.

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		int slow = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			}
			nums[slow++] = nums[i];
		}
		return slow;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public int removeDuplicates2(int[] nums) {
		int slow = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.add(nums[i])) {
				nums[slow++] = nums[i];
			}
		}
		return slow;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
