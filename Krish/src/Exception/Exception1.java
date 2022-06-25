package src.Exception;

public class Exception1 {
	public static void main(String[] args) {
		try {
			int i = 9 / 0;
			System.out.println(i);
			return;
		} catch (Exception e) {
			System.out.println("exception caught");
			return;
		} finally {
			System.out.println("finally block executing");
		}
		// System.out.println("end");
	}
}