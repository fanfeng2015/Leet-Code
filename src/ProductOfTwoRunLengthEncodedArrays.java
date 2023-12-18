import java.util.ArrayList;
import java.util.List;

// LeetCode #1868 (Product of Two Run-Length Encoded Arrays)

// Run-length encoding is a compression algorithm that allows for an integer array nums with many segments of consecutive repeated 
// numbers to be represented by a (generally smaller) 2D array encoded. Each encoded[i] = [vali, freqi] describes the ith segment of 
// repeated numbers in nums where vali is the value that is repeated freqi times.

// - For example, nums = [1,1,1,2,2,2,2,2] is represented by the run-length encoded array encoded = [[1,3],[2,5]]. Another way to read 
//   this is "three 1's followed by five 2's".

// The product of two run-length encoded arrays encoded1 and encoded2 can be calculated using the following steps:
// - Expand both encoded1 and encoded2 into the full arrays nums1 and nums2 respectively.
// - Create a new array prodNums of length nums1.length and set prodNums[i] = nums1[i] * nums2[i].
// - Compress prodNums into a run-length encoded array and return it.

// You are given two run-length encoded arrays encoded1 and encoded2 representing full arrays nums1 and nums2 respectively. Both nums1 
// and nums2 have the same length. Each encoded1[i] = [vali, freqi] describes the ith segment of nums1, and each encoded2[j] = [valj, 
// freqj] describes the jth segment of nums2.

// Return the product of encoded1 and encoded2.

// Note: Compression should be done such that the run-length encoded array has the minimum possible length.

public class ProductOfTwoRunLengthEncodedArrays {

	public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
		List<List<Integer>> result = new ArrayList<>();
		int p1 = 0, p2 = 0;
		while (p1 < encoded1.length && p2 < encoded2.length) {
			int[] one = encoded1[p1], two = encoded2[p2];
			int product = one[0] * two[0];
			int count = Math.min(one[1], two[1]);
			if (result.size() == 0 || result.get(result.size() - 1).get(0) != product) {
				List<Integer> list = new ArrayList<>();
				list.add(product);
				list.add(count);
				result.add(list);
			} else {
				List<Integer> list = result.get(result.size() - 1);
				list.set(1, list.get(1) + count);
			}
			one[1] -= count;
			two[1] -= count;
			if (one[1] <= 0) {
				p1++;
			}
			if (two[1] <= 0) {
				p2++;
			}
		}
		return result;
	}

	// Time complexity is O(min(m, n)).
	// Space complexity is O(1).
}
