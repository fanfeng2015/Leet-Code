import java.util.HashMap;
import java.util.Map.Entry;

// LeetCode #1570 (Dot Product of Two Sparse Vectors).

// Given two sparse vectors, compute their dot product.

// Implement class SparseVector:
// - SparseVector(nums) Initializes the object with the vector nums
// - dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
// - A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

// Follow up: What if only one of the vectors is sparse?

public class DotProductOfTwoSparseVectors {

	HashMap<Integer, Integer> map = new HashMap<>();

	DotProductOfTwoSparseVectors(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				map.put(i, nums[i]);
			}
		}
	}

	public int dotProduct(DotProductOfTwoSparseVectors vec) {
		int result = 0;
		// Optimization: Pick the space vector with a map of smaller size to iterate on.
		for (Entry<Integer, Integer> entry : map.entrySet()) {

			result += entry.getValue() * vec.map.getOrDefault(entry.getKey(), 0);
		}
		return result;
	}

	// n: number of elements
	// m: number of non-zero element
	// Time complexity is O(n) for constructor and O(m) for dot product.
	// Space complexity is O(m) for constructor and O(1) for dot product.

}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);	
