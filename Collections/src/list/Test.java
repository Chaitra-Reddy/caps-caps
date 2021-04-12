package list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test 
{

	public static void main(String[] args) 
	{
		List<Student> list = new ArrayList<>(); 
		
		list.add(new Student(1,"chinnu","fossils"));
		list.add(new Student(2,"hithu","biology"));
		list.add(new Student(3,"chaitra","history"));
		list.add(new Student(4,"arun","maths"));
		list.add(new Student(5,"vinod","art"));
		list.add(new Student(6,"vinay","cse"));
		
//		System.out.println(list.toString());
		
		//using iterator
//		Iterator<Student> itr = list.iterator();
//		while(itr.hasNext())
//		{
//			System.out.println(itr.next());
//		}
		
		//using forEach
//		list.forEach(i -> System.out.println(i));
		
		String str = list.stream().map(x -> x.getName()).reduce("",(x,y) -> (x+y));
		System.out.println("Concatenated all names: " + str);
		
		int sum = list.stream().map(x -> x.getId()).reduce(0,(x,y) -> (x+y));
		System.out.println("Sum of all IDs: " + sum);
		
		list.removeIf(x -> x.getName().equals("chaitra"));
		
		//list iterator
		ListIterator<Student> list1 = list.listIterator(0);
		while(list1.hasNext())
		{
			System.out.println(list1.next());
		}
	}

}

class Student
{
	private int id;
	private String name;
	private String subject;
	
	public Student() {}
	
	public Student(int id, String name, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() 
	{
		return "ID: " + id + " | NAME: " + name + "| SUBJECT: " + subject + "\n";
	}
}
