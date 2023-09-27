// LeetCode #238 (Product of Array Except Self).

// Given an integer array nums, return an array answer such that answer[i] is equal to the 
// product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int prefixProduct = 1;
		for (int i = 0; i < n; i++) {
			result[i] = prefixProduct;
			prefixProduct *= nums[i];
		}
		int suffixProduct = 1;
		for (int i = n - 1; i >= 0; i--) {
			result[i] *= suffixProduct;
			suffixProduct *= nums[i];
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
