// LeetCode #920 (Number of Music Playlists).

// Your music player contains N different songs and she wants to listen to L (not necessarily
// different) songs during your trip.  You create a playlist so that:

// 1. Every song is played at least once
// 2. A song can only be played again only if K other songs have been played
// 3. Return the number of possible playlists. As the answer can be very large, return it modulo
//    10^9 + 7.

public class NumberOfMusicPlayists {

	private static final int MOD = 1000000007;

	// M[i][j]: number of playlists of length i with j unique songs
	// M[i][j] = M[i - 1][j - 1] * (n - j + 1) + M[i - 1][j] * max(j - K, 0)
	public int numMusicPlaylists(int N, int L, int K) {
		long[][] M = new long[L + 1][N + 1];
		M[0][0] = 1;
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= N; j++) {
				M[i][j] += M[i - 1][j - 1] * (N - j + 1);
				M[i][j] += M[i - 1][j] * Math.max(j - K, 0);
				M[i][j] %= MOD;
			}
		}
		return (int) M[L][N];
	}

	// Time complexity is O(L*N).
	// Space complexity is O(L*N), but obviously can be optimized to O(N).
}
