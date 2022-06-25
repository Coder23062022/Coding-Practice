package src.Exception;

public class TryCatchFinally {
	public static void main(String[] args) {
		String valueReturned = tryCatchFinally();
		System.out.println(valueReturned);
	}

	// finally will override the try block return statement and will only print the
	// return statement in it. Finally will always execute before the try block.
	@SuppressWarnings("finally")
	public static String tryCatchFinally() {
		try {
			return "R";
		} catch (Exception e) {
			return "L";
		} finally {
//			System.out.println("H");
			return "H";
		}
	}
}
