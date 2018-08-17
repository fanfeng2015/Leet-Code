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

	// Solution 1: Segment tree
	private int n;
	private int[] segmentTree;

	public RangeSumQueryMutable(int[] nums) {
		this.n = nums.length;
		this.segmentTree = new int[2 * n];
		constructSegmentTree(nums);
	}

	public void update(int i, int val) {
		i += n;
		segmentTree[i] = val;
		i /= 2;
		while (i > 0) {
			segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
			i /= 2;
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

	// Time complexity is O(n) to construct the segment tree and O(log(n)) to update
	// and to query.
	// Space complexity is O(n).

/*
	// Solution 2: Binary indexed tree
	private int n;
	private int[] nums;
	private int[] bit;

	public RangeSumQueryMutable(int[] nums) {
		this.n = nums.length;
		this.nums = new int[n];
		bit = new int[n + 1];
		for (int i = 0; i < n; i++) {
			update(i, nums[i]);
		}
	}

	public void update(int i, int val) {
		int diff = val - nums[i];
		nums[i] = val;
		i++;
		while (i <= n) {
			bit[i] += diff;
			i += (i & -i); // 1->2, 2->4, 3->4, 4->8, 5->6, 6->8, 7->8, ...
		}
	}

	public int sumRange(int i, int j) {
		return findSum(j) - findSum(i - 1);
	}

	private int findSum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += bit[i];
			i -= (i & -i); // 8->0, 7->6, 6->4, 5->4, 4->0, 3->2, 2->0, 1->0, ...
		}
		return sum;
	}

	// Time complexity is O(n*log(n)) to construct the segment tree and O(log(n)) to
	// update and to query.
	// Space complexity is O(n).
*/
}
