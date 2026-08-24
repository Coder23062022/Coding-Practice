package Krish.src.GeneralProgram;

public class IterateAStringWithoutBuiltInMethods {
    public static void main(String[] args) {
        String s = "Hello World";

        //1st way to do
        int index = 0;
        do {
            String result = s.substring(index, index + 1);
            System.out.print(result);
            index++;
        } while (index != s.length());

        System.out.println(); //line break

        //2nd way to do
        index = 0;
        while (true) {
            String result = s.substring(index, index + 1);
            System.out.print(result);
            index++;
            if (index == s.length()) break;
        }

        System.out.println(); //line break

        //3rd way to do
        index = 0;
        while (true) {
            try {
                String result = s.substring(index, index + 1);
                System.out.print(result);
                index++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
    }
}