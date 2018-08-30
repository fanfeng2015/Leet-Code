// LeetCode #461 (Hamming Distance).

// The Hamming distance between two integers is the number of positions at 
// which the corresponding bits are different.

// Given two integers x and y, calculate the Hamming distance.

// Note: 0 <= x, y < 2^31

public class HammingDistance {

	public int hammingDistance(int x, int y) {
		int count = 0, xor = x ^ y;
		for (int i = 0; i < 32; i++) {
			count += xor & 1;
			xor >>= 1; // signed shift
		}
		return count;
	}

}
