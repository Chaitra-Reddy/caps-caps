package client;

import java.util.*;

public class Ko2 {

	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		list.add("chaitra");
//		list.add("vijju");
//		list.add("hithu");
//		list.add("vinay");
//		list.add("arun");
//		
//		System.out.println("\nThe iterator method----");
//		Iterator<String> iterator = list.iterator();
//		while(iterator.hasNext())
//		{
//			String name = iterator.next();
//			System.out.println(name);
//		}
//		
//		System.out.println("\nThe forEach method----");
////		list.forEach(i -> System.out.println(i));
//		list.forEach(System.out::println);

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");

		System.out.println("\nThe iterator method----");
		Iterator<Integer> keyIterator = map.keySet().iterator();
		while (keyIterator.hasNext()) {
			Integer key = keyIterator.next();
			String value = map.get(key);
			System.out.println(key + " --> " + value);
		}

		System.out.println("\nThe forEach method----");
	    map.forEach((i,j) -> System.out.println(i + " --> " + j));
	}

}
