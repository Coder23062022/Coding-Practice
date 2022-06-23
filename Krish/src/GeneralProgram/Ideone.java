package GeneralProgram;

import java.io.BufferedReader;
import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
 
class Ideone
{
	public static void doTestCase(BufferedReader br) throws Exception
	{
		Map<String, Integer> words = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			Integer cnt = words.get(word);
    		if (cnt == null) words.put(word, 1);
    		else words.put(word, cnt + 1);
		}
		String cmd = br.readLine();
		String[] parts = cmd.split(" ");
		if (parts.length == 2 && parts[0].equals("top")) {
			int cnt = Integer.parseInt(parts[1]);
			words.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(cnt)
				.forEach(System.out::println);
		}
	}
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			System.out.println("----------------");
			doTestCase(br);
		}
	}
}
