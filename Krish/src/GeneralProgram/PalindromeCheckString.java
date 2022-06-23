package GeneralProgram;

public class PalindromeCheckString {

	public static void main(String[] args) {
		
		String s1="madam";
		StringBuilder s2= new StringBuilder(s1);
		s2.reverse();
		System.out.println(s2.toString().equals(s1));
	}
}
