/*
The stock span problem is a financial problem where we have a series of n daily price 
quotes for a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of 
consecutive days just before the given day, for which the price of the stock on the current 
day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then 
the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
*/
package com.array.array;

public class StockSpanProblem {

	static void stockSpan(int arr[]) {
		int n = arr.length;
		int s[] = new int[n];
		int count=0;
		s[0]=1;
		
		for(int i=1;i<n;i++) {
			count=1;
				while(i-count>=0 && arr[i]>=arr[i-count]) {
					count+=s[i-count];
				}
				s[i]=count;
		}
		
		for(int i=0;i<n;i++)
			System.out.print(s[i]+" ");
	}
	
	public static void main(String[] args) {
		int arr[]= {10,4,5,90,120,80};
		stockSpan(arr);
	}
}
//Time Complexity: O(n). It seems more than O(n) at first look. 
//If we take a closer look, we can observe that every element of 
//array is added and removed from stack at most once. So there are total 
//2n operations at most. Assuming that a stack operation takes O(1) time, 
//we can say that the time complexity is O(n).