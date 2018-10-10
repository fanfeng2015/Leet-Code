// LeetCode #375 (Guess Number Higher or Lower II).

// We are playing the Guess Game. The game is as follows:

// I pick a number from 1 to n. You have to guess which number I picked.

// Every time you guess wrong, I'll tell you whether the number I picked 
// is higher or lower.

// However, when you guess a particular number x, and you guess wrong, you
// pay $x. You win the game when you guess the number I picked.

// Given a particular n >= 1, find out how much money you need to have to 
// guarantee a win.

public class GuessNumberHigherOrLower2 {

	// M[i][j]: amount of money to guarantee a win to guess a number in [i, j]
	// M[i][j] = min(k + max(M[i][k - 1], M[k + 1][j]), for all k in [i, j].
	public int getMoneyAmount(int n) {
		int[][] M = new int[n + 1][n + 1];
		for (int i = n; i >= 1; i--) {
			for (int j = i + 1; j <= n; j++) { // M[i][i] = 0
				M[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					int left = (k > i) ? M[i][k - 1] : 0;
					int right = (k < j) ? M[k + 1][j] : 0;
					M[i][j] = Math.min(M[i][j], k + Math.max(left, right));
				}
			}
		}
		return M[1][n];
	}

	// Time complexity is O(n^3).
	// Space complexity is O(n^2).
}
