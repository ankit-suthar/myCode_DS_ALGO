/*
Given a string as an input. We need to write a program that will print all non-empty substrings of that given string.

Examples :

Input :  abcd
Output :  a 
          b
          c
          d
          ab
          bc
          cd
          abc
          bcd
          abcd

*/
package com.array.array;

public class PrintAllSubstringsOfGivenString {
	
	static void printAllString(String str) {
		
		int n = str.length();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<=n;j++)
			{
				System.out.println(str.substring(i, j));
			}
		}
	}

	public static void main(String[] args) {
		String str = "abcd";
		
		printAllString(str);
	}
}
