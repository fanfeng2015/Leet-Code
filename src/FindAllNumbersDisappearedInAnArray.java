import java.util.ArrayList;
import java.util.List;

// LeetCode #448 (Find All Numbers Disappeared in an Array).

// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some 
// elements appear twice and others appear once.

// Find all the elements of [1, n] inclusive that do not appear in this array.

public class FindAllNumbersDisappearedInAnArray {

	// Solution 1
	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int pos = i, cur = nums[i];
			while (cur != pos + 1) {
				pos = cur - 1;
				int temp = nums[pos];
				nums[pos] = cur;
				cur = temp;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				result.add(i + 1);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Solution 2
	public List<Integer> findDisappearedNumbers2(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] > 0) {
				nums[pos] *= -1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

}
