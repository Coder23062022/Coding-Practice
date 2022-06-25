package src.Strings;

public class StringEncodeDecode {
    public static void main(String[] args) {
        String[] arr = {"abc", "def", "gh"};
        System.out.println("Encoded string: " + encode(arr));
        String str = encode(arr);
        String[] result = decode(str);
        System.out.print("Decoded string: ");
        for (String s : result) {
            if (s != null)
                System.out.print(s + " ");
        }
    }

    static String encode(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            int length = s.length();
            sb.append(length).append("/").append(s);
        }
        return sb.toString();
    }

    static String[] decode(String str) {
        int i = 0, j = 0;
        String[] arr = new String[100];
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i)) && str.charAt(i + 1) == '/') {
                StringBuilder sb = new StringBuilder();
                int x = 0;
                int y = Character.getNumericValue(str.charAt(i));
                while (x < y) {
                    sb.append(str.charAt(i + 2));
                    i++;
                    x++;
                }
                arr[j] = sb.toString();
                j++;
                i = i + 2;
            }
        }
        return arr;
    }
}