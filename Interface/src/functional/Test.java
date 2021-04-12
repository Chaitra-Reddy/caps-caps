package functional;

public class Test
{
	public static void main(String[] args)
	{
		Person.drink();
		
		Person obj = () -> System.out.println("Doing plank..");
		obj.eat();
		obj.exercise();
	}
}
