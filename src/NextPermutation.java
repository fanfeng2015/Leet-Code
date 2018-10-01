// LeetCode #31 (Next Permutation).

// Implement next permutation, which rearranges numbers into the lexicographically 
// next greater permutation of numbers. If such arrangement is not possible, it must
// rearrange it as the lowest possible order (ie, sorted in ascending order).

// The replacement must be in-place, do not allocate extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding
// outputs are in the right-hand column.

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int k = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				k = i;
				break;
			}
		}
		if (k == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		for (int i = nums.length - 1; i > k; i--) {
			if (nums[i] > nums[k]) {
				swap(nums, k, i);
				reverse(nums, k + 1, nums.length - 1);
				return;
			}
		}
	}

	private void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
