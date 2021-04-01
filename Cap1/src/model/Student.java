package model;

import java.util.Comparator;

public class Student implements Comparable<Student>
{
	private int id;
	private String name;
	private String subject;
	
	public Student() {}
	
	public Student(int id, String name, String subject) 
	{
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
	
	public String toString() {
		return "ID: " + this.getId() + "\nName: " + this.getName() + "\nSubject: " + this.getSubject();
	}

	@Override
	public int compareTo(Student s) 
	{
		return this.id - s.id;
	}
	
	public static Comparator<Student> StudentNameComparator = new Comparator<Student>()
			{

				@Override
				public int compare(Student s1, Student s2) 
				{
					return (s1.getName().compareTo(s2.getName()));
				}
		
			};
			
	public static Comparator<Student> StudentSubjectComparator = new Comparator<Student>()
			{

				@Override
				public int compare(Student s1, Student s2) 
				{
					return (s1.getSubject().compareTo(s2.getSubject()));
				}
		
			};
			
	public static Comparator<Student> StudentNameAndThenSubjectComparator = new Comparator<Student>()
			{

				@Override
				public int compare(Student s1, Student s2) 
				{
					int flag = s1.getName().compareTo(s2.getName());
					if(flag == 0)
					{
						flag = s1.getSubject().compareTo(s1.getSubject());
					}
					return flag;
				}
		
			};
}
