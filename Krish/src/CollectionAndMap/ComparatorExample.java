package CollectionAndMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	String fname;
	String lname;
	int age;

	public Employee(String fname, String lname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}
}

public class ComparatorExample {
	public static void main(String[] args) {
		Employee emp1 = new Employee("Krishnendu", "Banerjee", 30);
		Employee emp2 = new Employee("Soumyadeb", "Chatterjee", 29);
		Employee emp3 = new Employee("Dipanjan", "Mukherjee", 30);
		Employee emp4 = new Employee("Radhika", "Das", 29);
		List<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);

		System.out.println("Before sorting");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).fname + " " + list.get(i).lname + " " + list.get(i).age);

		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				int comp = e1.getFname().compareTo(e2.getFname());

				if (comp != 0) {
					return comp;
				}
				return (Integer.valueOf(e1.getAge()).compareTo(Integer.valueOf(e2.getAge())));
			}
		});

//		Collections.sort(list,
//				(Comparator<? super Employee>) (Employee e1, Employee e2) -> e1.getFname().compareTo(e2.getFname()));

		System.out.println("\nAfter sorting");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).fname + " " + list.get(i).lname + " " + list.get(i).age);
	}
}