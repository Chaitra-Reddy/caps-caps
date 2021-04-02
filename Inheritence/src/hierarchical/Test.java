package hierarchical;

class A
{
	public int val = 5;
}

class B extends A
{
	public void display() 
	{
		System.out.println(val);
	}
}

class C extends A
{
	public void display() 
	{
		System.out.println(val+1);
	}
}

public class Test 
{

	public static void main(String[] args) 
	{
		B obj = new B();
		obj.display();
		
		C obj1 = new C();
		obj1.display();
	}

}
