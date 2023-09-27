package com.Array;

public class ObjectArrayExample {
	
	public static void main(String[] args) {
		
		Object array1[]=new Object[4];
		
		array1[0]="10";
		array1[1]="Selenium";
		array1[2]="A";
		array1[3]=10.4567;
		
		/*
		 * System.out.println(array1[0]); System.out.println(array1[1]);
		 */
		
//		OR
		
		/*
		 * for(int arrayIndex=0;arrayIndex<array1.length;arrayIndex++) {
		 * System.out.println(array1[arrayIndex]); }
		 */
		
//		OR
		
		for(Object arrayIndex:array1)
		{
			System.out.println(arrayIndex);
		}
		
	}
}

	
	

