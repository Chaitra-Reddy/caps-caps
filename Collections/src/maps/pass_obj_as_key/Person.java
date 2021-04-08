package maps.pass_obj_as_key;

public class Person 
{
	private int id;
	private String name;
	private byte age;
	
	public Person() {}
	
	public Person(int id, String name, byte age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == 0) ? 0 : (new Integer(id).hashCode()));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((age == 0) ? 0 : (new Byte(age).hashCode()));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == 0) {
			if (other.id != 0)
				return false;
		}else if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (age == 0) {
			if (other.age != 0)
				return false;
		} else if (!(age == other.age))
			return false;
		return true;
	}
	
	@Override
	public String toString() 
	{
		return "Person [id = " + id + ", name = " + name + ", age = " + age + "]";
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

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}
}
