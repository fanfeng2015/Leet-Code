import java.util.Map;
import java.util.HashMap;

// LeetCode #535 (Encode and Decode TinyURL).

// TinyURL is a URL shortening service where you enter a URL such as 
// https://leetcode.com/problems/design-tinyurl and it returns a short 
// URL such as http://tinyurl.com/4e9iAk.

// Design the encode and decode methods for the TinyURL service. There is
// no restriction on how your encode/decode algorithm should work. You just
// need to ensure that a URL can be encoded to a tiny URL and the tiny URL
// can be decoded to the original URL.

public class EncodeAndDecodeTinyURL {

	private static final int ENCODING_LENGTH = 6;
	private static final String BASE_HOST = "http://tinyurl.com/";
	private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-,";

	private Map<String, String> shortToLong = new HashMap<>();
	private Map<String, String> longToShort = new HashMap<>();

	public String encode(String longUrl) {
		if (longToShort.containsKey(longUrl)) {
			return BASE_HOST + longToShort.get(longUrl);
		}
		StringBuilder encoding = new StringBuilder();
		do {
			encoding.setLength(0);
			encoding.trimToSize();
			for (int i = 0; i < ENCODING_LENGTH; i++) {
				int index = (int) (Math.random() * SEED.length());
				encoding.append(SEED.charAt(index));
			}
		} while (shortToLong.containsKey(encoding.toString()));

		shortToLong.put(encoding.toString(), longUrl);
		longToShort.put(longUrl, encoding.toString());

		return BASE_HOST + encoding;
	}

	public String decode(String shortUrl) {
		return shortToLong.get(shortUrl.replace(BASE_HOST, ""));
	}

}
