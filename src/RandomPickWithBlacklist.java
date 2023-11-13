import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// LeetCode #710 (Random Pick with Blacklist).

// You are given an integer n and an array of unique integers blacklist. Design an algorithm to pick a random integer in the range
// [0, n - 1] that is not in blacklist. Any integer that is in the mentioned range and not in blacklist should be equally likely to be 
// returned.

// Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.

// Implement the Solution class:
// - Solution(int n, int[] blacklist) Initializes the object with the integer n and the blacklisted integers blacklist.
// - int pick() Returns a random integer in the range [0, n - 1] and not in blacklist.

public class RandomPickWithBlacklist {

	// Solution 1: Create a white list. O(1) calls to Math.random().
	// Time complexity is O(N).
	// Space complexity is O(N).

	// Solution 2: for each element in [0, N - B.length), map the i-th black element
	// to the i-th white element in [N - B.length, N - 1].

	// N = 6, i.e., [0, 1, 2, 3, 4, 5]
	// B = [0, 2, 3]
	// 1. Let W = [3, 4, 5] - B = [4, 5]
	// 2. map = { 0: 4, 2: 5 }

	// Note: For map, no particular order is needed, i.e., { 0: 5, 2: 4 } works too.

	int size; // sample size
	Map<Integer, Integer> map;

	public RandomPickWithBlacklist(int N, int[] B) {
		map = new HashMap<>();
		size = N - B.length;
		Set<Integer> W = new HashSet<>();
		for (int i = size; i < N; i++) {
			W.add(i);
		}
		for (int x : B) {
			W.remove(x);
		}
		Iterator<Integer> iter = W.iterator(); // no particular order
		for (int x : B) {
			if (x < size) {
				map.put(x, iter.next());
			}
		}
	}

	public int pick() {
		int k = new Random().nextInt(size);
		return map.getOrDefault(k, k);
	}

	// Time complexity is O(N + B) for pre-processing, but O(1) thereafter.
	// Space complexity is O(N) for pre-processing, but O(1) thereafter.
}
