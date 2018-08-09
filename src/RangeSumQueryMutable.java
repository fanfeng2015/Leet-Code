// LeetCode #307 (Range Sum Query - Mutable).

// Given an integer array nums, find the sum of the elements between indices i 
// and j (i ≤ j), inclusive.

// The update(i, val) function modifies nums by updating the element at index i 
// to val.

// Notes:
// 1. The array is only modifiable by the update function.
// 2. You may assume the number of calls to update and sumRange function is 
//    distributed evenly.

public class RangeSumQueryMutable {

	int n;
	int[] segmentTree;

	public RangeSumQueryMutable(int[] nums) {
		this.n = nums.length;
		segmentTree = new int[2 * n];
		constructSegmentTree(nums);
	}

	public void update(int i, int val) {
		i += n;
		segmentTree[i] = val;
		i /= 2;
		while (i > 0) {
			segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
			i /= 1;
		}
	}

	public int sumRange(int i, int j) {
		int sum = 0;
		i += n;
		j += n;
		while (i <= j) {
			if (i % 2 == 1) {
				sum += segmentTree[i++];
			}
			if (j % 2 == 0) {
				sum += segmentTree[j--];
			}
			i /= 2;
			j /= 2;
		}
		return sum;
	}

	private void constructSegmentTree(int[] nums) {
		for (int i = n; i < 2 * n; i++) {
			segmentTree[i] = nums[i - n];
		}
		for (int i = n - 1; i > 0; i--) {
			segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
		}
	}

	// Time complexity is O(n) to construct the segment tree, O(log(n)) to update
	// and to query.
	// Space complexity is O(n).

}
