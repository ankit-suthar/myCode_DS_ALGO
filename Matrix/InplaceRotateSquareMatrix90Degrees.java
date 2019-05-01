/*
Given an square matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.

Examples:

Input
 1  2  3
 4  5  6
 7  8  9

Output:
 3  6  9 
 2  5  8 
 1  4  7 

Input:
 1  2  3  4 
 5  6  7  8 
 9 10 11 12 
13 14 15 16 

Output:
 4  8 12 16 
 3  7 11 15 
 2  6 10 14 
 1  5  9 13
 
 
 How to do without extra space?
Below are some important observations.

First row of source –> First column of destination, elements filled in opposite order

Second row of source –> Second column of destination, elements filled in opposite order

so … on

Last row of source –> Last column of destination, elements filled in opposite order.

An N x N matrix will have floor(N/2) square cycles. For example, a 4 X 4 matrix will have 2 cycles. 
The first cycle is formed by its 1st row, last column, last row and 1st column. 
The second cycle is formed by 2nd row, second-last column, second-last row and 2nd column.

The idea is for each square cycle, we swap the elements involved with the corresponding cell 
in the matrix in anti-clockwise direction i.e. from top to left, left to bottom, bottom to 
right and from right to top one at a time. We use nothing but a temporary variable to achieve this.

Below steps demonstrate the idea

First Cycle (Involves Red Elements)
 1  2  3 4 
 5  6  7  8 
 9 10 11 12 
 13 14 15 16 

 
Moving first group of four elements (First
elements of 1st row, last row, 1st column 
and last column) of first cycle in counter
clockwise. 
 4  2  3 16
 5  6  7 8 
 9 10 11 12 
 1 14  15 13 
 
Moving next group of four elements of 
first cycle in counter clockwise 
 4  8  3 16 
 5  6  7  15  
 2  10 11 12 
 1  14  9 13 

Moving final group of four elements of 
first cycle in counter clockwise 
 4  8 12 16 
 3  6  7 15 
 2 10 11 14 
 1  5  9 13 


Second Cycle (Involves Blue Elements)
 4  8 12 16 
 3  6 7  15 
 2  10 11 14 
 1  5  9 13 

Fixing second cycle
 4  8 12 16 
 3  7 11 15 
 2  6 10 14 
 1  5  9 13
 
*/
package com.matrix.matrix;

public class InplaceRotateSquareMatrix90Degrees {
	
	static void rotateMatrix(int mat[][])
	{
		int N = mat.length;
		
		for(int i=0;i<N/2;i++)
		{
			for(int j=i;j<N-i-1;j++)
			{
				int temp = mat[i][j];
				mat[i][j] = mat[j][N-i-1];
				mat[j][N-i-1] = mat[N-i-1][N-j-1];
				mat[N-i-1][N-j-1] = mat[N-j-1][i];
				mat[N-j-1][i] = temp;
			}
		}
	}
	
	static void printMatrix(int mat[][])
	{
		int N = mat.length;
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(mat[i][j]+"  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int mat[][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		System.out.println("Original matrix:");
		printMatrix(mat);
		System.out.println();
		
		rotateMatrix(mat);
		System.out.println("90 degree rotated matrix:");
		printMatrix(mat);
	}
}

// Time complexity : O(n)