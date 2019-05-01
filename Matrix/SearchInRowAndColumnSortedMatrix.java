/*
Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. 
Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. 
The designed algorithm should have linear time complexity.

Example :

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output : Found at (2, 1)

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 100
Output : Element not found

We have two approach to search an element in row and column wise sorted matrix,

eithr we can start from top right corner of the matrix or we can also start from bottom left corner of the matrix.

Below both solutions is given, in first solution, starting from top right corner, and in 
commented one starting from bottom left corner.
*/

package com.matrix.matrix;

public class SearchInRowAndColumnSortedMatrix {

	static void search(int mat[][], int n, int val)
	{
		
		int i=0,j=n-1;
		
		while(i<n && j>=0)
		{
			if(mat[i][j]==val)
			{
				System.out.println("Element found at "+i+" & "+j);
				break;
			}
			
			if(mat[i][j]<val)
				i++;
			else
				j--;
		}
		
    System.out.println("Not Found");
    
		//Alternate solutions
		/*
		int i=n-1,j=0;
		
		while(i>=0 && j<n)
		{
			if(mat[i][j]==val)
			{
				System.out.println("Element found at "+i+" & "+j);
				break;
			}
			
			if(mat[i][j]<val)
				j++;
			else
				i--;
		}
    
    System.out.println("Not Found");
		*/
	}
	public static void main(String[] args) {
		int mat[][] = { 
				{10, 20, 30, 40}, 
        {15, 25, 35, 45}, 
        {27, 29, 37, 48}, 
        {32, 33, 39, 50} 
        }; 

		search(mat, 4, 35);
	}
}
//If n x n matrix, Time Complexity: O(n)
//If m x n matrix, Time Complexity : O(m + n)
