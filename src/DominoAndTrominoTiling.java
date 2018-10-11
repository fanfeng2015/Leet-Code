// LeetCode #790 (Domino and Tromino Tiling).

// We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes
// may be rotated.

// XX  <- domino

// XX  <- "L" tromino
// X

// Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.

// In a tiling, every square must be covered by a tile. Two tilings are different if and only
// if there are two 4-directionally adjacent cells on the board such that exactly one of the
// tilings has both squares occupied by a tile.)

// Note: N  will be in range [1, 1000].

public class DominoAndTrominoTiling {

	private static final int MAX = 1000;
	private static final int MOD = 1000000007;

	// A[i]: number of ways to tile i full columns, plus one single cell
	// B[i]: number of ways to tile i full columns
	// A[i] = A[i - 1] + B[i - 1], for one domino and one tromino
	// B[i] = B[i - 1] + B[i - 2] + 2 * A[i - 2], for one domino, two dominos, and
	// one tromino
	public int numTilings(int N) {
		long[] A = new long[MAX + 1], B = new long[MAX + 1];
		A[1] = 1; A[2] = 2;
		B[0] = 0; B[1] = 1; B[2] = 2;
		for (int i = 3; i <= N; i++) {
			A[i] = (A[i - 1] + B[i - 1]) % MOD;
			B[i] = (B[i - 1] + B[i - 2] + 2 * A[i - 2]) % MOD;
		}
		return (int) B[N];
	}

	// Time complexity is O(n).
	// Space complexity is O(n), but obviously can be optimized to O(1).
}
