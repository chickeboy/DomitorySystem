package User.Interface.layer;

import java.util.Scanner;

import Dormitory.Class.Student;

public class RegisteredMenu {
	public void registered() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("name");
		String name = scanner.next();
		System.out.println("sex");
		String sex = scanner.next();
		System.out.println("password");
		String password= scanner.next();
		System.out.println("phonenumber");
		String phonenumber= scanner.next();
		System.out.println("marjoer");
		String marjoer= scanner.next();
		System.out.println("Schoolcard");
		String schoolcard= scanner.next();
		Student student = new Student(name, sex, password, phonenumber, marjoer, schoolcard);
		
	}
}
