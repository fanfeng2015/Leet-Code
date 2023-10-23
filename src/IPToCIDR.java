import java.util.ArrayList;
import java.util.List;

// LeetCode #751 (IP to CIDR).

// An IP address is a formatted 32-bit unsigned integer where each group of 8 bits is printed as a decimal number and the dot character '.' 
// splits the groups.

// For example, the binary number 00001111 10001000 11111111 01101011 (spaces added for clarity) formatted as an IP address would be 
// "15.136.255.107".

// A CIDR block is a format used to denote a specific set of IP addresses. It is a string consisting of a base IP address, followed by a
// slash, followed by a prefix length k. The addresses it covers are all the IPs whose first k bits are the same as the base IP address.

// For example, "123.45.67.89/20" is a CIDR block with a prefix length of 20. Any IP address whose binary representation matches 
// 01111011 00101101 0100xxxx xxxxxxxx, where x can be either 0 or 1, is in the set covered by the CIDR block.

// You are given a start IP address ip and the number of IP addresses we need to cover n. Your goal is to use as few CIDR blocks as possible
// to cover all the IP addresses in the inclusive range [ip, ip + n - 1] exactly. No other IP addresses outside of the range should be covered.

// Return the shortest list of CIDR blocks that covers the range of IP addresses. If there are multiple answers, return any of them.

public class IPToCIDR {

	public List<String> ipToCIDR(String ip, int n) {
		long x = 0;
		String[] ips = ip.split("\\.");
		for (int i = 0; i < ips.length; ++i) {
			x = x * 256 + Integer.parseInt(ips[i]);
		}
		// 255.0.0.7
		// 11111111 00000000 00000000 00000111
		// x & -x = 1
		List<String> result = new ArrayList<>();
		while (n > 0) {
			long cover = x & -x; // gets the least significant bit
			if (cover == 0) { // ip = 0.0.0.0
				cover = Integer.highestOneBit(n); // n = 5 (101), then cover = 4 (100)
			}
			while (cover > n) {
				cover /= 2;
			}
			result.add(convert(x, cover));
			x += cover;
			n -= cover;
		}
		return result;
	}

	// 255.0.0.8
	// 11111111 00000000 00000000 00001000
	// -> 255.0.0.8/29
	private String convert(long x, long cover) { // cover = 8
		int[] ips = new int[4];
		ips[3] = (int) (x & 255);
		x >>= 8;
		ips[2] = (int) (x & 255);
		x >>= 8;
		ips[1] = (int) (x & 255);
		x >>= 8;
		ips[0] = (int) (x & 255);
		int k = 32 - (int) (Math.log(cover) / Math.log(2));
		return ips[0] + "." + ips[1] + "." + ips[2] + "." + ips[3] + "/" + k;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

// target = 192.168.0.1

// rules = {
//   "ALLOW", "8.8.8.8/8",
//   "DENY", "192.168.25.25/16",
// }

// return "DENY"

// ------------------------------
// Solution: 
// for each rule, get k, create a 32-bit mask where the first k are 1's and the rest are 0's
// convert target and rule to binary, mask on both, if the results match, return the status
