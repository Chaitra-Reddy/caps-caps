package entity;

public class Member implements Comparable<Member>{
	private int id;
	private String name;
	private int age;
	private char gender;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int id, String name, int age, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		return o.name.compareTo(this.getName());
	}

}
