package service;

public interface Welcome 
{
	default void welcomeByDefault()
	{
		System.out.println("WELCOME!! ...using default method");
	}
	static void welcomeByStatic()
	{
		System.out.println("WELCOME!! ...using static method");
	}
	String welcomeByName(String name);
}
