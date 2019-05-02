/*
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. 
Expected time complexity is O(n).

Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 (Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4

*/
package com.array.array;

public class LargestSubarrayEqualNumberOf0sAnd1s {
	
	static int findSubArray(int arr[],int n)
	{
		int sum = 0;
		int maxLength = -1;
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i=0;i<n-1;i++)
		{
			sum = (arr[i]==0) ? -1 : 1;
			
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]==0)
					sum+=-1;
				else
					sum+=1;
					
				if(sum==0 && maxLength<j-i+1)
				{
					maxLength = j-i+1;
					startIndex = i;
				}
			}
			endIndex = startIndex + maxLength - 1;			
		}
		
		if(maxLength == -1)
			System.out.println("No such subarray");
		else
			System.out.println(startIndex+" to "+endIndex);
		
		return maxLength;
	}

	public static void main(String[] args) {
		int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int size = arr.length;
 
        System.out.println(findSubArray(arr, size));
	}
}

// Time Complexity: O(n^2)
// Auxiliary Space: O(1)
