import java.util.Arrays;

// LeetCode #384 (Shuffle an Array).

// Shuffle a set of numbers without duplicates.

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
