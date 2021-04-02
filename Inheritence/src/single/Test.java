package single;

class Parent
{
	public void m1()
	{
		System.out.println("M1 parent method.");
	}
}

class Child extends Parent
{
	public void m1()
	{
		System.out.println("M1 child method.");
	}
}

public class Test 
{

	public static void main(String[] args) 
	{
//		Parent p = new Parent();
		Parent p = new Child();
//		Child p = (Child) new Parent();
		p.m1();
	}

}
