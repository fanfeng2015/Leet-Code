// LeetCode #96 (Unique Binary Search Trees).

// Given n, how many structurally unique BST's (binary search trees) that store values
// 1, ..., n?

public class UniqueBinarySearchTrees {

	// array[i]: number of different BSTs generated from 1, ..., i
	// array[i] = array[j - 1] * array[i - j], for j = 1, ..., i
	public int numTrees(int n) {
		int[] array = new int[n + 1];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				array[i] += array[j - 1] * array[i - j];
			}
		}
		return array[n];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// Mathematically this is called Catalan number, Cn = (2n)!/(n+1)!*n!
	public int numTrees2(int n) {
		return binomialCoefficient(2 * n, n) / (n + 1);
	}

	private int binomialCoefficient(int n, int k) {
		int result = 1;
		// C(n, k) = C(n, n - k)
		if (k > n - k) {
			k = n - k;
		}
		for (int i = 0; i < k; i++) {
			result *= (n - i);
			result /= (i + 1);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
