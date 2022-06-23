package Strings;

public class Stringcheck {
    public static void main(String[] args) {
        String s1 = "Krish";
        StringBuilder s2 = new StringBuilder("Krish");
        StringBuffer s7 = new StringBuffer("Krish");
        StringBuffer s4 = new StringBuffer("s1");
        String s5 = new String("Krish");
        String s6 = new String("Krish");
        s6.intern();
        s5 = s5.intern();
        //If you use StringBuffer here also, it will act same as StringBuilder
        String s3 = new String("Krish");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s4));
        System.out.println(s1 == s5);
        System.out.println(s1.equals(s5));
        System.out.println(s1 == s6);
        System.out.println(s1.equals(s6));
        //System.out.println(s7==s2);
        System.out.println(s2.equals(s7));
    }
}
