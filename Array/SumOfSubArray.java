package com.tejas.network;

/*
An array X consists of N elements. You are given an integer K.


Write a program to find the sum of the lengths of the sub-arrays with K as its maximum number.
Any two sub-arrays that are considered should not overlap each other. Find the maximum possible sum.

I/P:
N  K
5  4
4 8 5 2 4

O/P:
3

I/P:
N  K
10  3
7 2 3 1 2 3 1 6 2 3

O/P:
8

I/P:
N  K
1  2
3

O/P:
0
*/

import java.util.ArrayList;
import java.util.HashSet;

public class SumOfSubArray {
	
	static int getSubArray(int arr[],int K)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
		int max=0;
		int j=0;
		int i=j;
		
		while(i<arr.length)
		{
			al = new ArrayList<Integer>();
			
			if(arr[i]<=K)
				for(j=i;j<arr.length;j++)
					if(arr[j]<=K)
						al.add(arr[j]);
					else
						break;
			j++;
			i=j;
			
			if(al.size()>=1 && !hs.contains(al))
			{
				max += al.size();
				hs.add(al);
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		//int arr[] = {4,8,5,2,4};
		//int K=4;
		int arr[] = {3};
		int K=2;
		//int arr[] = {7,2,3,1,2,3,1,6,2,3};
		//int K=3;
		System.out.println(getSubArray(arr,K));
	}
}