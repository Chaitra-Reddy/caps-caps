package client;

import java.util.Arrays;
import java.util.Scanner;

import model.Student;

public class Ko3 
{
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) 
	{
		int choice = 0;
		Student students[] = new Student[5];
		students[0] = new Student(1004,"Elena Gilbert","Biology");
		students[1] = new Student(1003,"Katherine","Survival Skills");
		students[2] = new Student(1005,"Stefan Salvator","Maths");
		students[3] = new Student(1001,"Bonnie Benette","Dark Arts");
		students[4] = new Student(1002,"Katherine","English");
		
		do
		{
			System.out.println("\n-----------WELCOME---------------");
			System.out.println("Choose one from below:");
			System.out.println("(1) Sort students based on ID.");
			System.out.println("(2) Sort students based on Name.");
			System.out.println("(3) Sort students based on Subject.");
			System.out.println("(4) Sort students based on Name and then Subject.");
			System.out.println("(5) Exit.");
			System.out.println("---------------------------------\n");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: //Sort students based on ID
				Arrays.sort(students);
				for(Student s: students)
				{
					System.out.println(s);
					System.out.println();
				}
				break;
				
			case 2: //Sort students based on Name
				Arrays.sort(students, Student.StudentNameComparator);
				for(Student s: students)
				{
					System.out.println(s);
					System.out.println();
				}
				break;
				
			case 3: //Sort students based on Subject
				Arrays.sort(students, Student.StudentSubjectComparator);
				for(Student s: students)
				{
					System.out.println(s);
					System.out.println();
				}
				break;
				
			case 4: //Sort students based on Name and then Subject
				Arrays.sort(students, Student.StudentNameAndThenSubjectComparator);
				for(Student s: students)
				{
					System.out.println(s);
					System.out.println();
				}
				break;
			
			case 5: //Exit
				System.out.println("Exited.");
				return;
			}
		}
		while(choice != 4);
	}
}
