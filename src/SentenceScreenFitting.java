// LeetCode #418 (Sentence Screen Fitting).

// Given a rows x cols screen and a sentence represented by a list of non-empty words,
// find how many times the given sentence can be fitted on the screen.

// Notes:
// 1. A word cannot be split into two lines.
// 2. The order of words in the sentence must remain unchanged.
// 3. Two consecutive words in a line must be separated by a single space.
// 4. Total words in the sentence won't exceed 100.
// 5. Length of each word is greater than 0 and won't exceed 10.
// 6. 1 <= rows, cols <= 20,000.

public class SentenceScreenFitting {

	// Greedy (TLE)
	public int wordsTyping(String[] sentence, int rows, int cols) {
		int count = 0;
		int row = 0, col = 0, index = 0;
		while (row < rows) {
			if (sentence[index].length() <= cols - col) {
				col += sentence[index++].length() + 1; // single space between words
				if (index == sentence.length) {
					count++;
					index = 0;
				}
			} else {
				row++;
				col = 0;
			}
		}
		return count;
	}

	// Time complexity is O(r*c).
	// Space complexity is O(1).

	// Optimization
	public int wordsTyping2(String[] sentence, int rows, int cols) {
		int index = 0;
		String joint = String.join(" ", sentence) + " ";
		for (int row = 0; row < rows; row++) {
			index += cols;
			while (index > 0 && joint.charAt(index % joint.length()) != ' ') {
				index--;
			}
			index++;
		}
		return index / joint.length();
	}

	// Time complexity is O(n*k + r*c).
	// Space complexity is O(n*k).

	// Although time complexity is worse, assumption 4 and 5 make O(n*k) not too
	// bad, and in practice it runs faster than the above.
}
