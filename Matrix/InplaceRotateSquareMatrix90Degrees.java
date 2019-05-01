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
