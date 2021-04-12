package maps.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test 
{

	public static void main(String[] args) 
	{
		Mentor mentor1 = new Mentor(101, "John");
		Student student1 = new Student(1,"johnny",78);
		
		Mentor mentor2 = new Mentor(102, "Sam");
		Student student2 = new Student(1,"sammy",93);
		
		Mentor mentor3 = new Mentor(104, "Jim");
		Student student3 = new Student(1,"jimmy",67);
		
		Mentor mentor4 = new Mentor(103, "Scott");
		Student student4 = new Student(1,"scotty",82);
		
		Mentor mentor5 = new Mentor(105, "David");
		Student student5 = new Student(1,"davvi",87);
		
//		Map<Mentor,Student> students = new HashMap<>();
//		
//		students.put(mentor1, student1);
//		students.put(mentor2, student2);
//		students.put(mentor3, student3);
//		students.put(mentor4, student4);
//		students.put(mentor5, student5);
		
		Map<Mentor,Student> students = new TreeMap<>();
		
		students.put(mentor1, student1);
		students.put(mentor2, student2);
		students.put(mentor3, student3);
		students.put(mentor4, student4);
		students.put(mentor5, student5);
		
		for(Map.Entry<Mentor, Student> entry:students.entrySet())
		{
			System.out.println("KEY: " + entry.getKey().toString());
			System.out.println("ENTRY: " + entry.getValue().toString());
			System.out.println();
		}
	}

}
