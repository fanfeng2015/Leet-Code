import java.util.HashSet;
import java.util.Set;

// LeetCode #421 (Maximum XOR of Two Numbers in an Array).

// Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

// Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

// Could you do this in O(n) runtime?

public class MaximumXOROfTwoNumbersInAnArray {

	// Solution 1: Bit manipulation, don't understand...
	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		for (int i = 31; i >= 0; i--) {
			mask |= (1 << i);
			Set<Integer> set = new HashSet<Integer>();
			for (int num : nums) {
				set.add(num & mask); // only keep bits that are to the left of i
			}
			int target = max | (1 << i);
			for (int num : set) {
				if (set.contains(target ^ num)) {
					max = target; // find such a pair, break
					break;
				}
			}
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: Trie
	public int findMaximumXOR2(int[] nums) {
		TrieNode root = initializeTrie(nums);
		int max = 0;
		for (int num : nums) {
			int sum = 0;
			TrieNode cur = root;
			for (int i = 31; i >= 0; i--) {
				// increment sum only if some number has a different bit at this position
				int bit = (num >>> i) & 1; // unsigned right shift
				if (cur.children[bit ^ 1] != null) {
					sum += (1 << i);
					cur = cur.children[bit ^ 1];
				} else { // all numbers' current bit is the same
					cur = cur.children[bit];
				}
			}
			max = Math.max(max, sum);
		}
		return max;
	}

	private TrieNode initializeTrie(int[] nums) {
		TrieNode root = new TrieNode();
		for (int num : nums) {
			TrieNode cur = root;
			for (int i = 31; i >= 0; i--) {
				int bit = (num >>> i) & 1; // unsigned right shift
				if (cur.children[bit] == null) {
					cur.children[bit] = new TrieNode();
				}
				cur = cur.children[bit];
			}
		}
		return root;
	}

	private class TrieNode {
		TrieNode[] children;

		TrieNode() {
			this.children = new TrieNode[2];
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
