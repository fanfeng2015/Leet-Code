// LeetCode #977 (Squares of a Sorted Array).

// Given an integer array nums sorted in non-decreasing order, return an array of the squares
// of each number sorted in non-decreasing order.

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                result[i] = nums[right] * nums[right];
                right--;
            } else {
                result[i] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
    
	// Time complexity is O(n).
	// Space complexity is O(1).	
}
