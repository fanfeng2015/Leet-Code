// LeetCode #204 (Count Primes).

// Count the number of prime numbers less than a non-negative number, n.

public class CountPrimes {

	// Sieve of Eratosthenes
	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i < n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime[i]) {
				count++;
			}
		}
		return count;
	}

	// Time complexity is O(n * log(n) * log(n)).
	// Space complexity is O(n).
}
