// LeetCode #338 (Counting Bits).

// Given a non negative integer number num. 
// For every numbers i in the range 0 ≤ i ≤ num, calculate the number of 1's in their binary representation and 
// return them as an array.

public class CountingBits {

	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			result[i] = result[i / 2] + i % 2;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1), ignoring space needed for output.
}
