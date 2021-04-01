package client;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import service.impl.AppService;

public class Application
{
	private static Scanner sc = new Scanner(System.in);
	private static AppService service = new AppService();

	public static void main(String[] args) 
	{
		int choice = 0;
		List<String> names = null;
		
		do
		{
			System.out.println("\n----- WELCOME TO MULTI TASKER ------");
			System.out.println("Choose one of the following:");
			System.out.println("(1) Calculate the square.");
			System.out.println("(2) Display welcome message.");
			System.out.println("(3) Display welcome message by name.");
			System.out.println("(4) Display all names in uppercase.");
			System.out.println("(5) Find if name is in the list.");
			System.out.println("(6) Find sum of first 10 natural numbers.");
			System.out.println("(7) Exit.");
			System.out.println("------------------------------------\n");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("\nEnter the number:");
				int number = sc.nextInt();
				System.out.println("\nSquare is: " + service.calculateSquare(number));
				break;
				
			case 2: 
				service.welcomeMsg();
				break;
				
			case 3:
				System.out.println("\nEnter the name:");
				sc.nextLine();
				String name = sc.nextLine();
				String msg = service.welcomeByName(name);
				System.out.println(msg);
				break;
				
			case 4:
				names = new ArrayList<String>();
				names.add("chaitra"); names.add("arun"); names.add("hithu"); names.add("vijju");
				names.add("sai"); names.add("vinay"); names.add("vinod"); names.add("pooja");
				
				System.out.println("\nAll names in upper case: \n");
				service.namesInUppercase(names);
				break;
				
			case 5:
				names = new ArrayList<String>();
				names.add("chaitra"); names.add("arun"); names.add("hithu"); names.add("vijju");
				names.add("sai"); names.add("vinay"); names.add("vinod"); names.add("pooja");
				
				System.out.println("\nEnter a name:");
				sc.nextLine();
				String tempName = sc.nextLine();
				System.out.println("\n" + service.isNameInList(names,tempName));
				break;
				
			case 6:
				int sum = service.sumOfNaturalNumbers();
				System.out.println("\nSum of first 10 natural numbers: " + sum);
				break;
				
			case 7:
				System.out.println("\nExited.");
				return;
			}
		}
		while(choice != 6);
	}
}


