package Exception;

public class ExceptionTest {
	public static void main(String[] args) {
		String entries[] = { "entry 1", "entry 2" };
		int count = 0;
		while (entries[count] != null) {
			System.out.println(count);
			count++;
		}
		System.out.println(count);
	}
}
