// LeetCode #556 (Next Greater Element III).

// Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and
// is greater in value than n. If no such positive integer exists, return -1.

// Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit
// integer, return -1.

public class NextGreaterElement3 {

	public int nextGreaterElement(int n) {
		String s = String.valueOf(n);
		int[] nums = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			nums[i] = Character.getNumericValue(s.charAt(i));
		}
		return nextPermutation(nums);
	}

	// LeetCode #31 (Next Permutation).
	private int nextPermutation(int[] nums) {
		int k = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				k = i;
				break;
			}
		}
		if (k == -1) {
			return -1;
		}
		for (int i = nums.length - 1; i > k; i--) {
			if (nums[i] > nums[k]) {
				swap(nums, k, i);
				reverse(nums, k + 1, nums.length - 1);

				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < nums.length; j++) {
					sb.append(nums[j]);
				}
				// might overflow
				return Long.parseLong(sb.toString()) > Integer.MAX_VALUE ? -1 : Integer.parseInt(sb.toString());
			}
		}
		return -1; // should never reach here
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
	// Space complexity is O(n).
}
