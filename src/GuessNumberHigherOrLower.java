// LeetCode #374 (Guess Number Higher or Lower).

// We are playing the Guess Game. The game is as follows:

// I pick a number from 1 to n. You have to guess which number I picked.
// Every time you guess wrong, I'll tell you whether the number is higher or lower.
// You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

// -1: My number is lower
// 1: My number is higher
// 0: Congrats! You got it!

public class GuessNumberHigherOrLower extends GuessGame {

	public int guessNumber(int n) {
		int left = 1, right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int result = guess(mid);
			if (result == 0) {
				return mid;
			} else if (result < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}