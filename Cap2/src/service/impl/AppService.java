package service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import service.Square;
import service.Welcome;

public class AppService implements Welcome
{
	public int calculateSquare(int number)
	{
		Square s = (int x)->x*x;
		int res =  s.calculate(number);
		System.out.println(res);
		return res;
	}
	
	public void welcomeMsg()
	{
		AppService a = new AppService();
		a.welcomeByDefault();
		Welcome.welcomeByStatic();
		
	}

	@Override
	public String welcomeByName(String name) 
	{
		return "\nWelcome " + name + "!!";
	}
	
	public void namesInUppercase(List<String> names)
	{
		List<String> uppercaseNames = names.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
		
		System.out.println(uppercaseNames);
	}
	
	public boolean isNameInList(List<String> names, String key)
	{
		String name="";
		
		name = names.stream()
				.filter(s -> s.equals(key))
				.findAny()
				.orElse(null);
		
		if(name!=null)
		{
			return true;
		}
		return false;
	}
	
	public int sumOfNaturalNumbers()
	{
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		return Arrays.stream(arr).sum();
	}
}
