import java.util.Arrays;

// LeetCode #283 (Move Zeroes).

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

public class MoveZeroes {

	public int[] moveZeroes(int[] array) {
		int left = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				array[left++] = array[i];
			}
		}
		Arrays.fill(array, left, array.length, 0);
		return array;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
