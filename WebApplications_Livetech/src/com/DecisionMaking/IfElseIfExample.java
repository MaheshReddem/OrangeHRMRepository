package com.DecisionMaking;

public class IfElseIfExample {
	
	public static void main(String[] args) {
		
		int var1=20;
		int var2=30;
		int var3=50;
		
		if(var1>var2 && var1>var3)
		{
			System.out.println(" The value of variable var1 is greater than value of variables var2 and var3 ");
		}
		else
		{
			if(var2>var1 && var2>var3)
			{
				System.out.println(" The value of variable var2 is greater than value of variables var1 and var3 ");
			}
			else
			{
				System.out.println(" The value of variable var3 is greater than value of variables var1 and var2 ");
			}
			
		}
		
		
	}

}
