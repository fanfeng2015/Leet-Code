import java.util.HashMap;
import java.util.Map;

// LeetCode #166 (Fraction to Recurring Decimal).

// Given two integers representing the numerator and denominator of a fraction, 
// return the fraction in string format.

// If the fractional part is repeating, enclose the repeating part in parentheses.

public class FractionToRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		// positive or negative
		sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
		long a = Math.abs((long) numerator);
		long b = Math.abs((long) denominator);
		// integral part
		sb.append(a / b);
		a %= b;
		if (a == 0) {
			return sb.toString();
		}
		// decimal part
		sb.append(".");
		Map<Long, Integer> map = new HashMap<>();
		map.put(a, sb.length());
		while (a != 0) {
			a *= 10;
			sb.append(a / b);
			a %= b;
			if (map.containsKey(a)) {
				int index = map.get(a);
				sb.insert(index, "(");
				sb.append(")");
				break;
			} else {
				map.put(a, sb.length());
			}
		}
		return sb.toString();
	}

}
