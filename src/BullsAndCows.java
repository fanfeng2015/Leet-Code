// LeetCode #299 (Bulls and Cows).

// You are playing the following Bulls and Cows game with your friend: You write down
// a number and ask your friend to guess what the number is. Each time your friend makes 
// a guess, you provide a hint that indicates how many digits in said guess match your 
// secret number exactly in both digit and position (called "bulls") and how many digits
// match the secret number but locate in the wrong position (called "cows"). Your friend
// will use successive guesses and hints to eventually derive the secret number.

// Write a function to return a hint according to the secret number and friend's guess, use
// A to indicate the bulls and B to indicate the cows. 

// Please note that both secret number and friend's guess may contain duplicate digits.

public class BullsAndCows {

	// Solution 1: two passes
	// Assumption: secret and guess don't need to have the same length
	public String getHint(String secret, String guess) {
		int[] countMap = new int[10];
		int bulls = 0, cows = 0;
		int m = secret.length(), n = guess.length();
		for (int i = 0; i < m; i++) {
			if (i < n && secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				countMap[Character.getNumericValue(secret.charAt(i))]++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i < m && guess.charAt(i) == secret.charAt(i)) {
				continue;
			}
			if (countMap[Character.getNumericValue(guess.charAt(i))] > 0) {
				cows++;
				countMap[Character.getNumericValue(guess.charAt(i))]--;
			}
		}
		return bulls + "A" + cows + "B";
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).

	// Solution 2: one pass
	// Assumption: secret and guess have the same length
	public String getHint2(String secret, String guess) {
		int[] countMap = new int[10];
		int bulls = 0, cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			int m = Character.getNumericValue(secret.charAt(i));
			int n = Character.getNumericValue(guess.charAt(i));
			if (m == n) {
				bulls++;
			} else {
				if (countMap[m] < 0) {
					cows++;
				}
				if (countMap[n] > 0) {
					cows++;
				}
				countMap[m]++;
				countMap[n]--;
			}
		}
		return bulls + "A" + cows + "B";
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).
}