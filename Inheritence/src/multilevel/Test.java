package multilevel;

class A
{
	public void m1()
	{
		System.out.println("In class A.");
	}
}

class B extends A
{
	public void m1()
	{
		System.out.println("In class B.");
	}
}

class C extends B
{
	public void m1()
	{
		System.out.println("In class C.");
	}
}

public class Test 
{

	public static void main(String[] args) 
	{
		A obj = new C();
		obj.m1();
	}

}
