/*
Given an array, how to check if the given array represents a Binary Max-Heap.

Examples:

Input:  arr[] = {90, 15, 10, 7, 12, 2} 
Output: True
The given array represents below tree
       90
     /    \
   15      10
  /  \     /
 7    12  2 
The tree follows max-heap property as every
node is greater than all of its descendants.

Input:  arr[] = {9, 15, 10, 7, 12, 11} 
Output: False
The given array represents below tree
       9
     /    \
   15      10
  /  \     /
 7    12  11
The tree doesn't follows max-heap property 9 is 
smaller than 15 and 10, and 10 is smaller than 11. 
*/
package com.array.array;

public class CheckGivenArrayBinaryHeap {
	
	static boolean checkBinaryHeap(int arr[]) {
		int n = arr.length;
		
		for(int i=n/2;i>=0;i--) 
		{
			if(2*i+1<n && arr[i]<arr[2*i+1])
				return false;
			
			if(2*i+2<n && arr[i]<arr[2*i+2])
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		int arr[] = {90, 15, 10, 7, 12, 2, 7, 3}; //{9, 15, 10, 7, 12, 11}; //{90, 15, 10, 7, 12, 2};
		
		if(checkBinaryHeap(arr))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
//Time complexity: O(n)