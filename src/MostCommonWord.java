import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// LeetCode #819 (Most Common Word).

// Given a paragraph and a list of banned words, return the most frequent word that
// is not in the list of banned words.  It is guaranteed there is at least one word
// that isn't banned, and that the answer is unique.

// Words in the list of banned words are given in lowercase, and free of punctuation.  
// Words in the paragraph are not case sensitive.  The answer is in lowercase.

public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {
		String[] split = paragraph.replaceAll("[!?',;.]", "").toLowerCase().split(" ");
		Set<String> set = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> countMap = new HashMap<>();
		for (int i = 0; i < split.length; i++) {
			if (!set.contains(split[i])) {
				Integer count = countMap.get(split[i]);
				count = count == null ? 1 : count + 1;
				countMap.put(split[i], count);
			}
		}
		int max = 0;
		String result = "";
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				result = entry.getKey();
			}
		}
		return result;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(m + n).
}
