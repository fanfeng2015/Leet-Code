// LeetCode #27 (Remove Elements).

// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The 
// order of the elements may be changed. Then return the number of elements in nums which are not equal 
// to val.

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int slow = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[slow++] = nums[i];
			}
		}
		return slow;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).	
}
