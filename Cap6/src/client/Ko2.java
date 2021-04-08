package client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Movie;

public class Ko2 {

	public static void main(String[] args) 
	{
		Movie m1 = new Movie("Shawshank Redemption", 1);
		String fileName = "C:\\Files\\SerialDemo.txt";

		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) 
		{
			// Saving the movie in text file
//			FileOutputStream file = new FileOutputStream(fileName);
//			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(m1);

//			out.close();
//			file.close();

			System.out.println("Movie has been serialized...");

		}
		catch (IOException e) 
		{
			System.out.println("IOException occured");
		}

		Movie m2 = null;

		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) 
		{
			// Reading the serialized movie from the text file
//			FileInputStream file = new FileInputStream(fileName);
//			ObjectInputStream in = new ObjectInputStream(file);

			m2 = (Movie) in.readObject();

			System.out.println("Movie has been deserialized...");
			System.out.println("Movie name is " + m2.getName());
			System.out.println("Movie rank is " + m2.getRank());
		} 
		catch (IOException ex) 
		{
			System.out.println("IOException occured");
		}
		catch (ClassNotFoundException ex) 
		{
			System.out.println("ClassNotFoundException occured");
		}
	}
}
