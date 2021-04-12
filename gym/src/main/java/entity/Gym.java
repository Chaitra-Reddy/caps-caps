package entity;

public class Gym implements Comparable<Gym> {

	private int id;
	private String name;
	private String instructorName;

	public Gym() {
		super();
	}

	public Gym(int id, String name, String instructorName) {
		super();
		this.id = id;
		this.name = name;
		this.instructorName = instructorName;
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

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	@Override
	public String toString() {
		return "Gym [id=" + id + ", name=" + name + ", instructorName=" + instructorName + "]";
	}

	@Override
	public int compareTo(Gym o) {
		return o.name.compareTo(this.name);
	}

}
