package src.GeneralProgram;

public class IntegerToOtherDTConverter {

	static void main() {
		int i = 3467;
		String by = Integer.toBinaryString(i);
		String hex = Integer.toHexString(i);
		String oct = Integer.toOctalString(i);
		System.out.println(by);
		System.out.println(hex);
		System.out.println(oct);
	}
}
