import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// LeetCode #220 (Contains Duplicate III).

// Given an array of integers, find out whether there are two distinct indices
// i and j in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k.

public class ContainsDuplicate3 {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0 || t < 0) {
			return false;
		}
		TreeSet<Long> treeSet = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				treeSet.remove((long) nums[i - k - 1]);
			}
			Long l = (long) nums[i];
			Long floor = treeSet.floor(l);
			Long ceiling = treeSet.ceiling(l);
			if ((floor != null && floor >= l - t) || (ceiling != null && ceiling <= l + t)) {
				return true;
			}
			treeSet.add(l);
		}
		return false;
	}

	// Time complexity is O(n * log(k)).
	// Space complexity is O(k).

	// Bucket sort
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (k <= 0 || t < 0) {
			return false;
		}
		int n = nums.length;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			Long value = (long) nums[i] - Integer.MIN_VALUE; // offset to avoid negative bucket number
			Long bucket = value / ((long) t + 1);
			if (map.containsKey(bucket) || map.containsKey(bucket - 1) && value - map.get(bucket - 1) <= t
					|| map.containsKey(bucket + 1) && map.get(bucket + 1) - value <= t) {
				return true;
			}
			if (map.entrySet().size() == k) {
				map.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1));
			}
			map.put(bucket, value);
		}
		return false;
	}

	// Note that the bucket size can be t or t + 1, but t + 1 avoids dividing by 0.

	// Time complexity is O(n).
	// Space complexity is O(n).
}
