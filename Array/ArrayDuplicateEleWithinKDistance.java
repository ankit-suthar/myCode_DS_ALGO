/*
Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array. Write a function that returns true if array contains duplicates within k distance.

Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true

A Simple Solution is to run two loops. The outer loop picks every element ‘arr[i]’ as a starting element, 
the inner loop compares all elements which are within k distance of ‘arr[i]’. 
The time complexity of this solution is O(kn).

We can solve this problem in Θ(n) time using Hashing. 
The idea is to one by add elements to hash. We also remove elements which are 
at more than k distance from current element. Following is detailed algorithm.

1) Create an empty hashtable.
2) Traverse all elements from left from right. Let the current element be ‘arr[i]’
….a) If current element ‘arr[i]’ is present in hashtable, then return true.
….b) Else add arr[i] to hash and remove arr[i-k] from hash if i is greater than or equal to k
*/
package com.array.array;

import java.util.HashSet;

public class ArrayDuplicateEleWithinKDistance {
	
	static boolean checkDuplicatesWithinK(int arr[],int k) {
		
		HashSet<Integer> h = new HashSet<Integer>();
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			
			if(h.contains(arr[i]))
				return true;
			
			h.add(arr[i]);
			
			if(i>=k)
				h.remove(arr[i-k]);
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {10, 5, 3, 4, 3, 5, 6}; 
    if (checkDuplicatesWithinK(arr, 3)) 
       System.out.println("Yes"); 
    else
       System.out.println("No"); 
	}
}
//Time complexity: O(n)