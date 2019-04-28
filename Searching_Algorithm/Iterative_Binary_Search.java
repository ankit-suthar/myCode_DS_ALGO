/*Iterative implementation of Binary Search*/
/*
  We basically ignore half of the elements just after one comparison.
1. Compare x with the middle element.
2. If x matches with middle element, we return the mid index.
3. Else If x is greater than the mid element, then x can only lie in right half subarray 
   after the mid element. So we recur for right half.
4. Else (x is smaller) recur for the left half.
*/
package com.searching.algorithm;

public class Iterative_Binary_Search {
	
	static int BinarySearch(int arr[],int l,int r,int s)
	{
		int mid;
		
		while(l<=r)
		{
			mid=(l+r)/2;
			
			if(arr[mid] == s)
				return mid;
			else if(s > arr[mid])
				l=mid+1;
			else
				r=mid-1;			
		}
		return -1;
	}


	public static void main(String[] args) {
		int arr[]={2,3,4,10,40};
		int x = 10;		
		
		int ans = BinarySearch(arr,0,arr.length-1,x);
		
		if(ans==-1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " +ans);

	}

}

/*T(n) = T(n/2) + c */
