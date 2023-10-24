// LeetCode #424 (Longest Repeating Character Replacement).

// You are given a string s and an integer k. You can choose any character of the string and change it to any other 
// uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int curMax = 0, left = 0, result = k;
		int[] countMap = new int[26];
		for (int i = 0; i < s.length(); i++) {
			curMax = Math.max(curMax, ++countMap[s.charAt(i) - 'A']);
			// window = [left, i], size = i - left + 1
			// curMax >= i - left + 1 - k, then you can update result
			while (curMax < i - left + 1 - k) { // but if not, you have to move left
				countMap[s.charAt(left) - 'A']--;
				left++;
				// why do you not need to update curMax?
				// because if curMax is smaller, you'll definitely not get a larger window
			}
			result = Math.max(result, i - left + 1);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
