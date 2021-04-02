package com.practice.shop.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.practice.shop.entity.Car;
import com.practice.shop.entity.Showroom;
import com.practice.shop.exception.InvalidBrandException;
import com.practice.shop.exception.InvalidIdException;

public class CarShowroomApp 
{
	private static Scanner sc = new Scanner(System.in);
	private static List<Showroom> showrooms = new ArrayList<Showroom>();

	public static void main(String[] args) 
	{
		int choice = 0;
		
		//mock data*****************************************
		Set<Car> mockCars1 = new HashSet<Car>();
		mockCars1.add(new Car(11, "car one", "maruti", 2022, 200000));
		mockCars1.add(new Car(12, "car two", "hyundai", 2023, 200000));
		mockCars1.add(new Car(13, "car three", "maruti", 2003, 200000));
		Showroom s1 = new Showroom(1002, "sai motors", mockCars1);
		
		Set<Car> mockCars2 = new HashSet<Car>();
		mockCars2.add(new Car(21, "car one", "maruti", 2013, 200000));
		mockCars2.add(new Car(22, "car two", "hyundai", 2003, 200000));
		mockCars2.add(new Car(23, "car three", "maruti", 2002, 200000));
		Showroom s2 = new Showroom(1001, "krishna motors", mockCars2);
		
		showrooms.add(s1);
		showrooms.add(s2);
		
		//**************************************************
		
		
		do
		{
			System.out.println("\n\n-------------------WELCOME--------------------------");
			System.out.println("Choose one from the options below:");
			System.out.println("(1) Add showroom and cars.");
			System.out.println("(2) Search car by showroom name.");
			System.out.println("(3) Sort showroom by id and cars in it by model year.");
			System.out.println("(4) Add car to a existing showroom.");
			System.out.println("(5) Exit.");
			System.out.println("--------------------------------------------------");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				try
				{
					Showroom s = addShowroom();
					displayShowroom(s);
				}
				catch(InvalidIdException e)
				{
					System.out.println("Duplicate ID is not allowed. Try again.");
				}
				catch(InvalidBrandException e)
				{
					System.out.println("Brand invalid. Only Maruti and Hyundai allowed. Try again.");
				}
				break;
				
			case 2:
				if(!showrooms.isEmpty())
				{
					System.out.println("\nEnter showroom name: ");
					sc.nextLine();
					String showroomName = sc.nextLine();
					Set<Car> cars = searchCarByShowroomName(showroomName);
					if(cars == null)
					{
						System.out.println("\nNo cars found!");
					}
					else
					{
						displayCar(cars);
					}
				}
				else
				{
					System.out.println("ERROR: No showrooms registered in the system.");
				}
				break;
				
			case 3:
				if(!showrooms.isEmpty())
				{
					showrooms = sortShowrooms(showrooms);
					for(Showroom s:showrooms)
					{
						displayShowroom(s);
						System.out.println("\n--------------------------");
					}
				}
				else
				{
					System.out.println("ERROR: No showrooms registered in the system.");
				}
				break;
				
			case 4:
				if(!showrooms.isEmpty())
				{
					System.out.println("\nEnter the showroom ID you want to add a car to: ");
					int showroomId = sc.nextInt();
					try
					{
						addCar(showroomId);
					}
					catch(InvalidIdException e)
					{
						System.out.println("Duplicate ID is not allowed. Try again.");
					}
					catch(InvalidBrandException e)
					{
						System.out.println("Brand invalid. Only Maruti and Hyundai allowed. Try again.");
					}
				}
				else
				{
					System.out.println("ERROR: No showrooms registered in the system.");
				}
				break;
				
			case 5:
				System.out.println("\nExited.");
				return;
			}
		}
		while(choice != 5);
	}
	
	
	//method to add showroom with cars
	public static Showroom addShowroom() throws InvalidIdException,InvalidBrandException
	{
		Set<Car> tempCars = new HashSet<Car>();
		Set<Integer> carIds = new HashSet<Integer>();
		
		System.out.println("\nEnter showroom ID:");
		int tempShowroomId = sc.nextInt();
		if(!showrooms.isEmpty())
		{
			if(findShowroomById(tempShowroomId) != null)
			{
				throw new InvalidIdException();
			}
		}
		
		System.out.println("\nEnter showroom name:");
		sc.nextLine();
		String tempShowroomName = sc.nextLine();
		
		System.out.println("\nEnter number of cars you want to add:");
		int noOfCars = sc.nextInt();
		
		for(int i=0; i<noOfCars; i++)
		{
			System.out.println("\nCar " + (i+1) + " details----");
			
			System.out.println("\nEnter car ID:");
			int tempCarId = sc.nextInt();
			if(!tempCars.isEmpty() && !carIds.isEmpty())
			{
				if(carIds.contains(tempCarId))
				{
					throw new InvalidIdException();
				}
			}
			
			System.out.println("\nEnter car name:");
			sc.nextLine();
			String tempCarName = sc.nextLine();
			
			System.out.println("\nEnter car brand:");
			String tempCarBrand = sc.nextLine();
			if(!checkBrand(tempCarBrand))
			{
				throw new InvalidBrandException();
			}
			
			System.out.println("\nEnter car model year:");
			int tempCarYear = sc.nextInt();
			
			System.out.println("\nEnter car price:");
			double tempCarPrice = sc.nextDouble();
			
			Car car = new Car(tempCarId,tempCarName,tempCarBrand,tempCarYear,tempCarPrice);
			
			carIds.add(tempCarId);
			tempCars.add(car);
		}
		
		Showroom s =  new Showroom(tempShowroomId,tempShowroomName,tempCars);
		showrooms.add(s);
		return s;
	}
	
	//method to display a showroom
	public static void displayShowroom(Showroom s)
	{
		System.out.println("\nShowroom ID: " + s.getId());
		System.out.println("\nShowroom name: " + s.getName());
		Set<Car> cars = s.getCars();
		System.out.println("\n==== Car Details =====");
		for(Car c: cars)
		{
			System.out.println("\nCar ID: " + c.getId());
			System.out.println("\nCar name: " + c.getName());
			System.out.println("\nCar brand: " + c.getBrand());
			System.out.println("\nCar model year: " + c.getModelYear());
			System.out.println("\nCar price: $" + c.getPrice());
			System.out.println("\n---------");
		}
	}
	
	public static void displayCar(Set<Car> cars)
	{
		for(Car c: cars)
		{
			System.out.println("\nCar ID: " + c.getId());
			System.out.println("\nCar name: " + c.getName());
			System.out.println("\nCar brand: " + c.getBrand());
			System.out.println("\nCar model year: " + c.getModelYear());
			System.out.println("\nCar price: $" + c.getPrice());
			System.out.println("\n---------");
		}
	}
	
	//check if showroom id already exists
	public static Showroom findShowroomById(int id)
	{
		for(Showroom s:showrooms)
		{
			if(s.getId() == id)
			{
				return s;
			}
		}
		return null;
	}
	
	//check for brand validity
	public static boolean checkBrand(String brand)
	{
		brand = upperCase(brand);
		if(brand.equals("MARUTI") || brand.equals("HYUNDAI"))
		{
			return true;
		}
		return false;
	}
	
	//convert string to uppercase
	public static String upperCase(String s) 
	{
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				res += (char) ((int) s.charAt(i) - 32);
			} else {
				res += s.charAt(i);
			}
		}
		return res;
	}
	
	//==========================================================================
	
	public static Set<Car> searchCarByShowroomName(String showroomName)
	{
		for(Showroom s:showrooms)
		{
			if(upperCase(s.getName()).equals(upperCase(showroomName)))
			{
				return s.getCars();
			}
		}
		return null;
	}
	
	//===========================================================================
	
	//method to sort the showrooms based on ID and then the cars in it based on model year
	public static List<Showroom> sortShowrooms(List<Showroom> showrooms)
	{
		Collections.sort(showrooms);
		return showrooms;
	}
	
	//============================================================================
	
	//add a car to an existing showroom
	public static void addCar(int showroomId) throws InvalidIdException, InvalidBrandException
	{
		if(findShowroomById(showroomId) != null)
		{
			Showroom s = findShowroomById(showroomId);
			int index = showrooms.indexOf(s);
			
			Set<Integer> carIds = new HashSet<Integer>();
			for(Car c:s.getCars())
			{
				carIds.add(c.getId());
			}
			
			System.out.println("\nEnter car ID:");
			int tempCarId = sc.nextInt();
			if(!(s.getCars()).isEmpty() && carIds.contains(tempCarId))
			{
				throw new InvalidIdException();
			}
			
			System.out.println("\nEnter car name:");
			sc.nextLine();
			String tempCarName = sc.nextLine();
			
			System.out.println("\nEnter car brand:");
			String tempCarBrand = sc.nextLine();
			if(!checkBrand(tempCarBrand))
			{
				throw new InvalidBrandException();
			}
			
			System.out.println("\nEnter car model year:");
			int tempCarYear = sc.nextInt();
			
			System.out.println("\nEnter car price:");
			double tempCarPrice = sc.nextDouble();
			
			Car car = new Car(tempCarId,tempCarName,tempCarBrand,tempCarYear,tempCarPrice);
			s.getCars().add(car);
			
			showrooms.set(index, s);
			
			for(Showroom s1:showrooms)
			{
				displayShowroom(s1);
				System.out.println("\n--------------------------");
			}
		}
		else
		{
			System.out.println("\nSorry! No showroom found having the entered ID.");
		}
	}
}
