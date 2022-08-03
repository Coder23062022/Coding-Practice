package src.Strings;

//Problem: https://practice.geeksforgeeks.org/problems/sum-of-numbers-or-number1219/1
//         https://leetcode.com/problems/add-strings/
//Video source: https://www.youtube.com/watch?v=HpvoxRok8NQ&t=11s&ab_channel=CodeWithEase

public class AddStrings {
    public static void main(String[] args) {
        String num1 = "51";
        String num2 = "49";
        System.out.println(addStrings(num1, num2));
    }

    static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int lenNum1 = num1.length() - 1;
        int lenNum2 = num2.length() - 1;
        int carry = 0;
        while (lenNum1 >= 0 || lenNum2 >= 0) {
            int sum = 0;
            if (lenNum1 >= 0) {
                sum += num1.charAt(lenNum1) - '0';
                lenNum1--;
            }
            if (lenNum2 >= 0) {
                sum += num2.charAt(lenNum2) - '0';
                lenNum2--;
            }
            sum += carry;
            carry = sum / 10;
            int digit = sum % 10;
            result.append((char) (digit + '0'));
        }

        //If there is any carry leftover append that to the result.
        if (carry > 0) {
            result.append((char) (carry + '0'));
        }

        //This is for a special case to handle. If the result comes with all 0's, then only one 0 we have to print.
        int j = result.length() - 1;
        while (j > 0 && result.charAt(j) == '0') {
            result.deleteCharAt(j);
            j--;
        }
        return result.reverse().toString();
    }
}
