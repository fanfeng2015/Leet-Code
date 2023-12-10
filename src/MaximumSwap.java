import java.util.Arrays;

// LeetCode #670 (Maximum Swap).

// You are given an integer num. You can swap two digits at most once to get the maximum valued number.

// Return the maximum valued number you can get.

public class MaximumSwap {

	public int maximumSwap(int num) {
		char[] array = String.valueOf(num).toCharArray();
		int n = array.length;
		int[] maxToTheRight = new int[n]; // index
		Arrays.fill(maxToTheRight, -1);
		for (int i = n - 2; i >= 0; i--) {
			int index = maxToTheRight[i + 1];
			if (index == -1 || array[i + 1] > array[index]) {
				maxToTheRight[i] = i + 1;
			} else {
				maxToTheRight[i] = index;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int index = maxToTheRight[i]; // index of the max digit to the right of i
			if (array[i] < array[index]) {
				swap(array, i, index);
				return Integer.parseInt(String.valueOf(array));
			}
		}
		return num;
	}

	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
