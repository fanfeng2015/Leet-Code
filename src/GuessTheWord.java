import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// LeetCode #843 (Guess the Word).

public class GuessTheWord {

	// Randomly guess a word, then shrink the word list.
	public void findSecretWord(String[] wordlist, Master master) {
		int matches = 0;
		for (int i = 0; i < 10; i++) {
			String guess = wordlist[new Random().nextInt(wordlist.length)];
			matches = master.guess(guess);
			List<String> nextWordlist = new ArrayList<>();
			for (String word : wordlist) {
				if (match(guess, word) == matches) {
					nextWordlist.add(word);
				}
			}
			wordlist = nextWordlist.toArray(new String[nextWordlist.size()]);
		}
	}

	// Counts the number of char matches between a and b.
	private int match(String a, String b) {
		int matches = 0;
		for (int i = 0; i < a.length(); ++i) {
			if (a.charAt(i) == b.charAt(i)) {
				matches++;
			}
		}
		return matches;
	}

	// Essentially, after each guess, the algorithm eliminates words with a
	// different match with the guess word.

	// Optimization: maximize the number of eliminations after each guess.
	// 1. For each word, compute { x: count of words with x matches }.
	// 2. Choose the word with the minimum maximum count.
	// 3. Guess word to get the number of matches.
	// 4. Eliminate words with a different number of matches with word.
	// 5. Repeat.
}
