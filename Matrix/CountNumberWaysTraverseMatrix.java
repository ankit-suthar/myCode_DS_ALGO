/*
Given a two-dimensional matrix, in how way can someone traverse it from top-left to bottom-right?
Condition- At any particular cell the possible moves are either down or right, no other steps possible.

If we look closely, we will find that the number of ways a cell can be reached is = Number of ways it can 
reach the cell above it + number of ways it can reach the cell which is left of it.
So, start filling the 2D array according to it and return the last cell after completely filling the array.
*/
package com.matrix.matrix;

public class CountNumberWaysTraverseMatrix {

	private static int countWays(int m,int n) {
		
		if(m==1 || n==1)
			return 1;
		
		return countWays(m-1,n) + countWays(m,n-1);
	}
	
	public static void main(String[] args) {
		int m=3,n=3;
		System.out.println(countWays(m,n));
	}
}