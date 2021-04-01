package client;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Application {
	public static void main(String[] args) {
		/*------------HashMap implementation----------------*/
		Map<Integer, String> hm = new HashMap<Integer, String>();
		// adding elements to the HashMap
		hm.put(9, "Red");
		hm.put(12, "Black");
		hm.put(6, "Green");
		hm.put(19, "White");
		System.out.println("HashMap iteration Order:");
		// iteration over map using for each loop
		for (Map.Entry<Integer, String> entry : hm.entrySet()) {
			// getting keys and values using method
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		/*------------TreeMap implementation----------------*/
		Map<Integer, String> tm = new TreeMap<Integer, String>();
		// adding elements to the TreeMap
		tm.put(9, "Red");
		tm.put(12, "Black");
		tm.put(6, "Green");
		tm.put(19, "White");
		System.out.println("TreeMap iteration Order:");
		// iteration over map using for each loop
		for (Map.Entry<Integer, String> entry : tm.entrySet()) {
			// getting keys and values using method
			// prints list in sorted order
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
