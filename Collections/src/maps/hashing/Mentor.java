package maps.hashing;

public class Mentor implements Comparable<Mentor>
{
	private int id;
	private String name;
	
	public Mentor() {}
	
	public Mentor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString()
	{
		return "id = " + id + " | name = " + name ;
	}

	@Override
	public int compareTo(Mentor o) 
	{
		if(this.id < o.id)
		{
			return -1;
		}
		else if(this.id > o.id)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
