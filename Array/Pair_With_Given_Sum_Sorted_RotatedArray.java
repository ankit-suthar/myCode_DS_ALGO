package com.array.array;

public class Pair_With_Given_Sum_Sorted_RotatedArray {

	static boolean PairSum(int arr[],int n,int sum)
	{
		int i;
		for(i=0;i<n-1;i++)
			if(arr[i]>arr[i+1])
				break;
		
		int l = (i+1) % n;  // l is now index of minimum element
		int r = i;        // r is now index of maximum element
		
		while(l!=r)
		{
			if(arr[l]+arr[r] == sum)
				return true;
			
			if(arr[l]+arr[r]<sum)
				l = (l+1)%n;
			else 
				r = (n+r-1)%n;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int arr[] = {11, 15, 6, 8, 9, 10};
    int sum = 21;
    int n = arr.length;
    
    if(PairSum(arr,n,sum))
    	System.out.println("Array has two elements with sum 21");
    else
    	System.out.println("Array doesn't have two elements with sum 21");
    
	}
}
