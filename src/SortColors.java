// LeetCode #75 (Sort Colors).

// Given an array with n objects colored red, white or blue, sort them in-place so that
// objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue 
// respectively.

// Note: You are not suppose to use the library's sort function for this problem.

public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int i = 0, j = 0, k = nums.length - 1;
		// [0, i): 0
		// [i, j): 1
		// [j, n - 1]: 2
		while (j <= k) {
			if (nums[j] == 0) {
				swap(nums, i++, j++);
			} else if (nums[j] == 1) {
				j++;
			} else {
				swap(nums, j, k--);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
