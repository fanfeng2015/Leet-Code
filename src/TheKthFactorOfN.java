import java.util.ArrayList;

// LeetCode #1492 (The kth Factor of n).

// You are given two positive integers n and k. A factor of an integer n is defined as an 
// integer i where n % i == 0.

// Consider a list of all factors of n sorted in ascending order, return the kth factor in 
// this list or return -1 if n has less than k factors.

public class TheKthFactorOfN {

	public int kthFactor(int n, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				list.add(i);
				if (--k == 0) {
					return i;
				}
			}
		}
		int last = list.get(list.size() - 1);
		if (last * last == n) {
			k++;
		}
		return (k > list.size()) ? -1 : n / list.get(list.size() - k);
	}
}

// n = 4, [1, 2]
// k = 3 -> 1, index should be 0 (size - 2)
// k = 4 -> 2, index should be -1 (size - 3)
// so increment k by 1, if n is a perfect square

// don't need that otherwise
// n = 7, [1]
// k = 2 -> 1, index should be 0 (size - 1)
