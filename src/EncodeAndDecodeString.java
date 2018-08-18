import java.util.ArrayList;
import java.util.List;

// LeetCode #271 (Encode and Decode String).

// Design an algorithm to encode a list of strings to a string. 

// The encoded string is then sent over the network and is decoded
// back to the original list of strings.

public class EncodeAndDecodeString {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.length()).append('/').append(s);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> list = new ArrayList<>();
		int start = 0, index = s.indexOf('/', start);
		while (index != -1) {
			int length = Integer.valueOf(s.substring(start, index));
			list.add(s.substring(index + 1, index + 1 + length));
			start = index + 1 + length;
			index = s.indexOf('/', start);
		}
		return list;
	}

	// Time complexity is O(n*m).
	// Space complexity is O(n*m).
}
