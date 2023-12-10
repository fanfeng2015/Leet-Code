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

	public int maximumSwap2(int num) {
		char[] array = String.valueOf(num).toCharArray();
		int n = array.length, index = -1;
		char max = '0';
		for (int i = 0; i < n - 1; i++) { // find the first digit where the next digit is greater
			if (array[i] < array[i + 1]) {
				index = i;
				max = array[i];
				break;
			}
		}
		if (index == -1) {
			return num;
		}
		int left = index, right = index;
		for (int i = index + 1; i < n; i++) { // to the right, find the max digit
			if (array[i] >= max) {
				max = array[i];
				right = i;
			}
		}
		for (; left > 0; left--) { // to the left, find the largest digit < max
			if (array[left - 1] >= max) {
				break;
			}
		}
		swap(array, left, right);
		return Integer.parseInt(String.valueOf(array));
	}

	// Time complexity is O(n).
	// Space complexity is O(n), but O(1) if input is given as a char array.
}
