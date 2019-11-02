package hashbrown;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
	private static final int size = 556;
	private static Map<String, Integer> table = new TreeMap<>();
	
	public static void main(String[] args) throws FileNotFoundException {

		//creates necessary object instances and receives file name
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a valid file name to be read: ");
		Scanner fileScan = new Scanner(new FileReader(scan.nextLine()));
		scan.close();

		HashTable hashy = new HashTable(size);
		DataEntry data;

		//loops through given file
		while ( fileScan.hasNext()) {

			//converts nextLine to uppercase
			//replaces anything not alphabetic with spaces
			//creates array of strings, delim'd at spaces

			String line = fileScan.nextLine().toUpperCase().replaceAll("[^A-Z]", " ").replaceAll("\\r\\n|\\r|\\n", " ");
			String[] arr = line.split(" ");


			//loops through string array
			//if not already in hash, hashes and enters word into table
			for (int i = 0; i<arr.length; i++) {

				String test = arr[i];
				data = new DataEntry(test, i);

				//System.out.println(arr[i]);

				hashy.insert(stringVal(arr[i]), data); // add the data to the hash table

				if ( ! table.containsKey( data.getKey() )) {
					table.put(data.getKey(), 1);
				}

				if(table.containsKey(data.getKey())) {
					table.put(data.getKey(), table.get(data.getKey()) + 1); // increment the count
				}
			}
		}

		fileScan.close();

			
	      hashy.printTable();
	      System.out.println();
	      
	      Iterator<Entry<String, Integer>> itr = table.entrySet().iterator();
	      
	      System.out.print("Sorted Output:");
	      System.out.println();
	      
	      while(itr.hasNext()) {
	    	  Entry<String, Integer> entry = itr.next(); 
	    	  System.out.println("Key = " + entry.getKey() +  ",\tCount = " + (entry.getValue() - 1));
	      }
	}

	public static int stringVal(String s) //this came from GeeksForGeeks then was modified
	{
		int sum_char = 0;

		// loop to sum the ascii value of chars
		for (int i = 0; i < s.length(); i++) {
			sum_char += (int)s.charAt(i);
		}

		if (s.length() == 0) {
			return 0;
		}

		//average of chars
		return sum_char / s.length();
	}

}