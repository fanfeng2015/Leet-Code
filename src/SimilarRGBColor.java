// LeetCode #800 (Similar RGB Color).

// In the following, every capital letter represents some hexadecimal digit from 0 to F.

// The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  

// For example, "#15C" is shorthand for the color "#1155CC".

// Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is 
// -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.

// Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, 
// and has a shorthand (that is, it can be represented as some "#XYZ").

public class SimilarRGBColor {

	public String similarRGB(String color) {
		return "#" + closest(color.substring(1, 3)) + closest(color.substring(3, 5)) + closest(color.substring(5));
	}

	public String closest(String component) {
		int val = Integer.parseInt(component, 16);
		val = (val / 17) + (val % 17 <= 8 ? 0 : 1);
		return String.format("%02x", 17 * val);
	}

}
