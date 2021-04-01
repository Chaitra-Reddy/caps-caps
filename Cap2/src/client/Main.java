package client;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		List<String> names = new ArrayList<String>();
		names.add("chaitra");
		names.add("arun");
		names.add("hithu");
		names.add("sai");
		names.add("vinay");
		names.add("vinod");
		names.add("pooja");
		names.add("vijju");
		
		List<String> uppercaseNames = names.stream()
		                                .filter(s -> s.startsWith("v"))
                                        .collect(Collectors.toList());
                                        
        System.out.println(uppercaseNames);
	}
}
