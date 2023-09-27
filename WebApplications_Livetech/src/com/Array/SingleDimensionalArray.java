package com.Array;

public class SingleDimensionalArray {
	
	public static void main(String[] args) {
		
		int customerID[]=new int[3];
		
		customerID[0]=10101;
		customerID[1]=10102;
		customerID[2]=10103;
		
//		Printing the array through print statements
		
		/*
		 * System.out.println(customerID[0]); System.out.println(customerID[1]);
		 * System.out.println(customerID[2]);
		 */
		
//		OR
		
//		Printing array through for loop
		
		/*
		 * for(int custIDIndex=0;custIDIndex<customerID.length;custIDIndex++) {
		 * System.out.println(customerID[custIDIndex]); }
		 */
		
//		OR
		
//		Printing through for each loop
		
		for(int custIDIndex:customerID)
		{
			System.out.println(custIDIndex);
		}
				
	}

}
