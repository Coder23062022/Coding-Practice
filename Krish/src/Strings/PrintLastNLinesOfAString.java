package src.Strings;

//Time complexity: O(n)
//Space complexity: O(n)

public class PrintLastNLinesOfAString {
    public static void main(String[] args) {
        String s1 = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7" +
                "\nstr8\nstr9\nstr10\nstr11\nstr12\nstr13" +
                "\nstr14\nstr15\nstr16\nstr17\nstr18\nstr19" +
                "\nstr20\nstr21\nstr22\nstr23\nstr24\nstr25";
        int n = 10;
        printLast(s1, n);
    }

    static void printLast(String s, int t) {
        //Array to store individual strings.
        String[] v = s.split("\n");

        if (v.length == 0) {
            System.out.println("ERROR: string doesn't " + "contain '\\n' character");
            return;
        }

        // If there are t last lines need to be fetched, traverse the array from t point till the end of the array and print the elements.
        if (v.length >= t) {
            for (int i = v.length - t; i < v.length; i++) {
                System.out.println(v[i]);
            }
        } else {
            //If the given t value is more than the string length, then return the entire string.
            for (String value : v) {
                System.out.println(value);
            }
        }
    }
}
