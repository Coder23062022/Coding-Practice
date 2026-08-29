package src.Strings;

public class ReverseASentence {
	static void main() {
		String str = "all you need is love";
		String[] arr = str.split(" ");
		String result = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			result += arr[i] + " ";
		}
		System.out.println(result.trim());
	}
}
