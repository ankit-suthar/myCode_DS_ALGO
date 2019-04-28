package com.searching.algorithm;

public class Linear_Search {
	
	static int search(int arr[],int s)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==s)
				return i;		
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int arr[]={2,6,4,8,9,3};
		
		int ans = search(arr,3);
		
		if(ans == -1)
			System.out.println("Given element is not present in an array ");		
		else
			System.out.println("Element is present at "+ans+" position in an array ");
			
	}
}

//The time complexity of above algorithm is O(n).

/*
Linear search is rarely used practically because other search algorithms such as the 
binary search algorithm and hash tables allow significantly faster searching comparison 
to Linear search.
*/