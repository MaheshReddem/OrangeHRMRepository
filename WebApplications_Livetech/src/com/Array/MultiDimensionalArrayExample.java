package com.Array;

public class MultiDimensionalArrayExample {
	
public static void main(String[] args) {
		
		String customerID[][]=new String[2][2];
		
		customerID[0][0]="Manoj";
		customerID[0][1]="SBI";
		customerID[1][0]="Kiran";
		customerID[1][1]="HDFC";
		
//		Printing array through print statements
		
		/*
		 * System.out.print(customerID[0][0]+" "); System.out.println(customerID[0][1]);
		 * 
		 * System.out.print(customerID[1][0]+" "); System.out.println(customerID[1][1]);
		 */
		
//		OR
//		Printing array through for loop
		
		for(int rowIndex=0;rowIndex<customerID.length;rowIndex++)
			{
			for(int columnIndex=0;columnIndex<customerID.length;columnIndex++)
			{
				System.out.print(customerID[rowIndex][columnIndex]+" ");
			}
			System.out.println();
			}
	

	}
}
