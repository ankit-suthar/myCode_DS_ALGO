package com.tejas.network;

/*
A number is called problematic if its decimal representation contians only 4's and 5's. 
The numbers 4,5,45,44,45454 - are some examples of problematic numbers whereas the numbers 41,300 are not.

Given, a number N, write a program to represent it as the sum of the minimum number of 
problematic numbers.
 
I/P: 5
O/P: 1
 
I/P: 49 --> 45 + 4
O/P: 2
*/

public class NumberProblem {
	
	static int getNumber(int n)
	{
		int count=0;
		
		if(n%10 == 9)
		{
			n = n-4;
			count++;
		}
		int rem=0;
		
		while(n>0)
		{
			rem = n%10;
			
			if(rem!=4 && rem!=5)
			{
				return count;
			}
			n=n/10;
		}
		count++;
		return count;		
	}

	public static void main(String[] args) {
		int n = 45459;
		
		System.out.println(getNumber(n));
	}
}