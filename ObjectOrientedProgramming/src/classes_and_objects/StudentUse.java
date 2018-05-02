package classes_and_objects;

import java.util.Scanner;
public class StudentUse {

	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		Student s1 = new Student();
		Student s2 = new Student();
		s1.name = "Tanuj";
		s1.rollNumber = 123;
		System.out.println(s1.name);
	}

}
