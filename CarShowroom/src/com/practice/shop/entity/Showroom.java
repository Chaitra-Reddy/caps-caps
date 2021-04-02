package com.practice.shop.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Showroom implements Comparable<Showroom>
{
	private int id;
	private String name;
	
	private Set<Car> cars;

	public Showroom() {
		super();
	}

	public Showroom(int id, String name, Set<Car> cars) {
		super();
		this.id = id;
		this.name = name;
		this.cars = cars;
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

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@Override
	public int compareTo(Showroom s) 
	{	
		List<Car> carsList = new ArrayList<Car>(s.getCars());
		
		Collections.sort(carsList, new Comparator<Car>() {
			public int compare(Car c1, Car c2) 
			{
	            if(c1.getModelYear() > c2.getModelYear())
	            {
	            	return 1;
	            }
	            else if(c1.getModelYear() < c2.getModelYear())
	            {
	            	return -1;
	            }
	            else
	            {
	            	return 0;
	            }
	        }
		});
		
		Set<Car> carsSet = new LinkedHashSet<>(carsList);
		s.setCars(carsSet);
		
		List<Car> carsList1 = new ArrayList<Car>(this.getCars());
		
		Collections.sort(carsList1, new Comparator<Car>() {
			public int compare(Car c1, Car c2) 
			{
	            if(c1.getModelYear() > c2.getModelYear())
	            {
	            	return 1;
	            }
	            else if(c1.getModelYear() < c2.getModelYear())
	            {
	            	return -1;
	            }
	            else
	            {
	            	return 0;
	            }
	        }
		});
		
		Set<Car> carsSet1 = new LinkedHashSet<>(carsList1);
		this.setCars(carsSet1);
		
		return (this.getId() - s.getId());
	}
}
