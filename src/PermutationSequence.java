import java.util.ArrayList;
import java.util.List;

// LeetCode #60 (Permutation Sequence).

// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
// "123", "132", "213", "231", "312", "321".

// Given n and k, return the kth permutation sequence.

// Note:
// Given n will be between 1 and 9 inclusive.
// Given k will be between 1 and n! inclusive.

public class PermutationSequence {

	// permutations of n = 4:
	// 1, { permutations of 2, 3, 4 }
	// 2, { permutations of 1, 3, 4 }
	// 3, { permutations of 1, 2, 4 }
	// 4, { permutations of 1, 2, 3 }
	public String getPermutation(int n, int k) {
		k--;
		StringBuilder sb = new StringBuilder();

		int[] factorial = new int[n + 1];
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i; // 1, 1, 2, 6, 24, ...
		}

		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			numbers.add(i + 1);
		}

		for (int i = 1; i <= n; i++) {
			int index = k / factorial[n - i]; // group index
			sb.append(numbers.get(index));
			numbers.remove(index); // O(n) time
			k -= index * factorial[n - i];
		}
		return sb.toString();
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// Note: It is tempting to use DFS, but the order of permutation sequence is not
	// the desired order.

	// Also see LeetCode #31 (Next Permutation).
}
