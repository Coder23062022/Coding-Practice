package Strings;

class StringRevWithRecursion {
    public static void main(String[] args) {
        StringRevWithRecursion obj = new StringRevWithRecursion();
        System.out.println(obj.method1("Krish"));
    }

    String method1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        } else {
            return method1(s.substring(1)) + s.charAt(0);
        }
    }

    String method2(String s) {
        if (s == null || s.length() <= 1)
            return s;

        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2);
        return method2(right) + method2(left);
    }
}