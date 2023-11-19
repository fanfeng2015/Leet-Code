import java.util.Arrays;

// LeetCode #384 (Shuffle an Array).

// Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally 
// likely as a result of the shuffling.

// Implement the Solution class:
// - Solution(int[] nums) Initializes the object with the integer array nums.
// - int[] reset() Resets the array to its original configuration and returns it.
// - int[] shuffle() Returns a random shuffling of the array.

public class ShuffleAnArray {

	private int[] nums;

	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
	}

	public int[] reset() {
		return nums;
	}

	public int[] shuffle() {
		int[] copy = Arrays.copyOf(nums, nums.length);
		if (copy == null || copy.length <= 1) {
			return copy;
		}
		for (int i = copy.length - 1; i >= 0; i--) {
			int random = (int) (Math.random() * (i + 1));
			swap(copy, random, i);
		}
		return copy;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
