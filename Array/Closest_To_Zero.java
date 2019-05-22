package com.tejas.network;

/*
You have been given an integer array A of size N.You
need to print the number with value closest to zero.
If there are multiple elements, print the number with 
greater value.

I/P:
0 2 3 4 5

O/P:
0

I/P:
2 -4 3 -2 5

O/P:
2


*/
import java.util.Arrays;

public class Closest_To_Zero {
	
	static int getNearest(int arr[],int N)
	{
		int near = arr[0];
		
		Arrays.sort(arr);
		
		int val=0;
		
		for(int i=0;i<N;i++)
		{
			val = arr[i];
			
			if((val*val)<=(near*near))
				near=val;
		}
		return near;
	}

	public static void main(String[] args) {
		//int arr[] = {0,2,3,4,5};
		int arr[] = {2,-4,3,-2,5};

		System.out.println(getNearest(arr,arr.length));
	}
}
//Time Complexity: O(n)