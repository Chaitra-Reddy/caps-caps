package maps.pass_obj_as_key;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) 
	{
		Map<Person,String> map = new HashMap<>();
		map.put(new Person(11,"chai",(byte)22), "blore");
		map.put(new Person(12,"vijju",(byte)23), "hyd");
		map.put(new Person(11,"chai",(byte)22), "tirupathi");
		
		map.forEach((k, v) -> System.out.println(k + " => " + v));
	}

}
