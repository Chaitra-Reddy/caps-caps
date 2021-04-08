package client;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) 
	{
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(1,100));
		cars.add(new Car(2,103));
		cars.add(new Car(3,120));
		cars.add(new Car(4,300));
		cars.add(new Car(5,400));
		
		double sum = cars.stream().reduce(0.0, (partialAgeResult, car) -> partialAgeResult + car.getCost(), Double::sum);
		
		System.out.println(sum);
	}

}

class Car
{
	private int id;
	private double cost;
	
	public Car() {}
	
	public Car(int id, double cost) {
		super();
		this.id = id;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
