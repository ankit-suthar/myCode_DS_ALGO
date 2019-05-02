/*
Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time. 
The converted array should be in form a < b > c < d > e < f.

Example: 
Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input:  arr[] =  {1, 4, 3, 2}
Output: arr[] =  {1, 4, 2, 3}

A Simple Solution is to first sort the array. After sorting, exclude the first element, 
swap the remaining elements in pairs. (i.e. keep arr[0] as it is, swap arr[1] and arr[2], 
swap arr[3] and arr[4], and so on). Time complexity is O(nlogn) since we need to sort the array first.

We can convert in O(n) time using an Efficient Approach. The idea is to use modified one pass 
of bubble sort. Maintain a flag for representing which order(i.e. < or >) currently we need. 
If the current two elements are not in that order then swap those elements otherwise not.
Let us see the main logic using three consecutive elements A, B, C. Suppose we are processing 
B and C currently and the current relation is ‘<'. But we have B > C. Since current relation 
is ‘<' previous relation must be '>‘ i.e., A must be greater than B. So, the relation is 
A > B and B > C. We can deduce A > C. So if we swap B and C then the relation is 
A > C and C < B. Finally we get the desired order A C B
*/
package com.array.array;

import java.util.Arrays;

public class ConvertArrayZigZag {
	
	static void zigZag(int arr[],int n) {
		
		boolean flag=true;
		int i,temp;
		
		for(i=0;i<n-1;i++) {
			
			if(flag) {
				
				if(arr[i]>arr[i+1]) {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
				flag=!flag;				
			}
			else {
				
				if(arr[i]<arr[i+1]) {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
				flag=!flag;
			}	
		}		
	}

	public static void main(String[] args) {
		int arr[] = new int[]{4, 5, 7, 8, 3, 6, 2, 1};//{4, 3, 7, 8, 6, 2, 1};		
		zigZag(arr,arr.length); 
    System.out.println(Arrays.toString(arr));
	}
}
//Time complexity: O(n)
//Auxiliary Space: O(1)