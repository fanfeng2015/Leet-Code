// LeetCode #468 (Validate IP Address).

public class ValidateIPAddress {

	public String validIPAddress(String ip) {
		return validIPv4(ip) ? "IPv4" : (validIPv6(ip) ? "IPv6" : "Neither");
	}

	private boolean validIPv4(String ip) {
		if (ip.length() < 7 || ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
			return false;
		}
		String[] tokens = ip.split("\\.");
		if (tokens.length != 4) {
			return false;
		}
		for (String token : tokens) {
			if (!validIPv4Token(token)) {
				return false;
			}
		}
		return true;
	}

	private boolean validIPv4Token(String token) {
		if (token.length() == 0 || token.length() > 3 || (token.charAt(0) == '0' && token.length() > 1)) {
			return false;
		}
		try {
			int value = Integer.parseInt(token);
			if (value < 0 || value > 255 || (value == 0 && token.charAt(0) != '0')) { // e.g., -0
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private boolean validIPv6(String ip) {
		if (ip.length() < 15 || ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
			return false;
		}
		String[] tokens = ip.split(":");
		if (tokens.length != 8) {
			return false;
		}
		for (String token : tokens) {
			if (!validIPv6Token(token)) {
				return false;
			}
		}
		return true;
	}

	private boolean validIPv6Token(String token) {
		if (token.length() == 0 || token.length() > 4) {
			return false;
		}
		char[] chars = token.toCharArray();
		for (char ch : chars) {
			if (!((ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 70) || (ch >= 97 && ch <= 102))) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
