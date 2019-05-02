/*
You are given a list of n-1 integers and these integers are in the range of 1 to n. 
There are no duplicates in list. One of the integers is missing in the list. 
Write an efficient code to find the missing integer.

Example :
Input: [1, 2, 4, ,6, 3, 7, 8]
Output:  5

METHOD 1(Use sum formula)
Algorithm:

1. Get the sum of numbers 
       total = n*(n+1)/2
2  Subtract all the numbers from sum and
   you will get the missing number.
*/

package com.array.array;

public class FindMissingNumber {
	
	static int getMissingNo(int arr[],int n){
		int sum = (n)*(n+1)/2;
		
		for(int i=0;i<n-1;i++){
			sum-=arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,9,10};
		int n = arr.length;
		System.out.println("Missing value is: "+getMissingNo(arr,n+1));
	}
}
// Time Complexity : O(n)
