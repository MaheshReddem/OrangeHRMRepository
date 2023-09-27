package com.Array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	
public static void main(String[] args) {
		
		List<Object>array1=new ArrayList<>();
		
		array1.add(20);
		array1.add("WebDriver");
		array1.add("A");
		array1.add(10.1234);
		
		System.out.println();
		System.out.println("The size of array index is: "+array1.size());
		
		/*
		 * System.out.println(array1.get(0)); System.out.println(array1.get(1));
		 * System.out.println(array1.get(2)); System.out.println(array1.get(3));
		 */
		
		/*
		 * for(int arrayIndex=0;arrayIndex<array1.size();arrayIndex++) {
		 * System.out.println(array1.get(arrayIndex)); }
		 */
		
		
		for(Object arrayIndex:array1)
		{
			System.out.println(arrayIndex);
		}
		
				
	}


}
