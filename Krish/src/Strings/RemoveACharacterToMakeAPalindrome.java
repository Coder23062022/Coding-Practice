package src.Strings;

public class RemoveACharacterToMakeAPalindrome {
	public static void main(String[] args) {
		String str = "abcbea"; // abecbea
		int idx = possiblePalinByRemovingOneChar(str);

		if (idx == -1)
			System.out.println("Not Possible");
		else if (idx == -2)
			System.out.println("Possible without " + "removing any character");
		else
			System.out.println("Possible by removing" + " character at index " + idx);
	}

	static boolean isPalindrome(String str, int low, int high) {
		while (low < high) {
			if (str.charAt(low) != str.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}

	// This method returns -1 if it is
	// not possible to make string a palindrome.
	// It returns -2 if string is already
	// a palindrome. Otherwise it returns
	// index of character whose removal can
	// make the whole string palindrome.
	static int possiblePalinByRemovingOneChar(String str) {

		// Initialize low and right
		// by both the ends of the string
		int low = 0, high = str.length() - 1;

		// loop untill low and
		// high cross each other
		while (low < high) {

			// If both characters are equal then
			// move both pointer towards end
			if (str.charAt(low) == str.charAt(high)) {
				low++;
				high--;
			} else {

				/*
				 * If removing str[low] makes the whole string palindrome. We basically check if
				 * substring str[low+1..high] is palindrome or not.
				 */
				if (isPalindrome(str, low + 1, high))
					return low;

				/*
				 * If removing str[high] makes the whole string palindrome. We basically check
				 * if substring str[low+1..high] is palindrome or not.
				 */
				if (isPalindrome(str, low, high - 1))
					return high;
				return -1;
			}
		}

		// We reach here when complete string
		// will be palindrome if complete string
		// is palindrome then return mid character
		return -2;
	}
}