// LeetCode #273 (Integer to English Words).

// Convert a non-negative integer num to its English words representation.

// Given input is guaranteed to be less than 2^31 - 1.

public class IntegerToEnglishWords {

	private final String[] LESSTHANTWENTY = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	private final String[] TENS = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };
	private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		int index = 0;
		String result = "";
		while (num > 0) {
			if (num % 1000 != 0) {
				result = convert(num % 1000) + THOUSANDS[index] + " " + result;
			}
			num /= 1000;
			index++;
		}
		return result.trim();
	}

	private String convert(int num) {
		if (num == 0) {
			return "";
		} else if (num < 20) {
			return LESSTHANTWENTY[num] + " ";
		} else if (num < 100) {
			return TENS[num / 10] + " " + convert(num % 10);
		} else {
			return LESSTHANTWENTY[num / 100] + " Hundred " + convert(num % 100);
		}
	}

	// Time complexity is O(n^2), where n is the length of input, because of string
	// concatenation.
	// Space complexity is O(n).
}
