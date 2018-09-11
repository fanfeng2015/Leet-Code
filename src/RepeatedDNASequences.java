import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// LeetCode #187 (Repeated DNA Sequences).

// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
// for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
// repeated sequences within the DNA.

// Write a function to find all the 10-letter-long sequences (substrings) that occur
// more than once in a DNA molecule.

public class RepeatedDNASequences {

	// Rolling hash.
	public List<String> findRepeatedDnaSequences(String s) {
		if (s.length() <= 10) {
			return new ArrayList<String>();
		}
		Map<Character, Integer> map = encode();
		Set<String> result = new HashSet<>();
		Set<Integer> set = new HashSet<>();
		int cur = 0;
		for (int i = 0; i < 10; i++) {
			cur <<= 2;
			cur |= map.get(s.charAt(i));
		}
		set.add(cur);
		for (int i = 1; i <= s.length() - 10; i++) {
			// (262143) in decimal = (111111111111111111) in binary
			cur &= 262143; // remove the highest two bits
			cur <<= 2;
			cur |= map.get(s.charAt(i + 10 - 1));
			if (!set.add(cur)) {
				result.add(s.substring(i, i + 10));
			}
		}
		return new ArrayList<String>(result);
	}

	// A --> 0, C --> 1, G --> 2, T --> 3
	private Map<Character, Integer> encode() {
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		return map;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

