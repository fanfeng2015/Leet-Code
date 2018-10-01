import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// LeetCode #128 (Longest Consecutive Sequence).

// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
// For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence is [1, 2, 3, 4]. 
// Return its length: 4.
// Your algorithm should run in O(n) complexity.

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		int cur = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] - nums[i - 1] == 1) {
				cur = cur + 1;
			} else if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				cur = 1;
			}
			max = Math.max(max, cur);
		}
		return max;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(log(n)).

	public int longestConsecutive2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int result = 0;
		for (int num : set) {
			if (!set.contains(num - 1)) {
				int next = num + 1;
				while (set.contains(next)) {
					next++;
				}
				result = Math.max(result, next - num);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
