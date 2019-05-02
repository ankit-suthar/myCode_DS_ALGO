/*
Find the Missing Number

You are given a list of n-1 integers and these integers are in the range of 1 to n. 
There are no duplicates in list. One of the integers is missing in the list. Write an 
efficient code to find the missing integer.

Example :
I/P    [1, 2, 4, ,6, 3, 7, 8]
O/P    5
*/
package com.array.array;

public class MissingNumber {
	
	static int getMissingNo(int a[],int n) {
		
		int m=n+1;
		int sum = m*(m+1)/2;
		
		for(int i=0;i<n;i++) {
			sum-=a[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int a[] = {1,2,4,5,6}; 
    int miss = getMissingNo(a,5); 
    System.out.println(miss); 
	}
}
//Time Complexity : O(n)