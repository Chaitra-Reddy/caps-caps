package functional;

@FunctionalInterface
public interface Person 
{
	public void exercise();
//	public void study();
	
	public static void drink()
	{
		System.out.println("Drinking water...");
	}
	
	public default void eat()
	{
		System.out.println("Eating..");
	}
}
