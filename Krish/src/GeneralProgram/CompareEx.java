package src.GeneralProgram;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    int rollNo;
    String name;
    int age;

    Student(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student st) {
        return Integer.compare(age, st.age);
    }
}

public class CompareEx {
    public static void main(String args[]) {
        ArrayList<Student> al = new ArrayList<Student>();
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));
        Collections.sort(al);
        for (Student st : al) {
            System.out.println(st.rollNo + " " + st.name + " " + st.age);
        }
    }
}
