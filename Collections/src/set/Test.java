package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test 
{

	public static void main(String[] args) 
	{
//		Set<Integer> set = new HashSet<>();
//		set.add(0);
//		set.add(1);
//		set.add(null);
//		set.add(null);
//		set.add(4);
		
		Set set = new TreeSet<>();
		set.add("a");
		set.add("a");
		
		System.out.println(set);
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

