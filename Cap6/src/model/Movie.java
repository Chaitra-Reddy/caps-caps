package model;

import java.io.Serializable;

public class Movie implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int rank;
	
	public Movie() {}
	
	public Movie(String name, int rank) {
		super();
		this.name = name;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
