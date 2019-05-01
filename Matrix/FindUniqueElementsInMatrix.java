/*
Given a matrix mat[][] having n rows and m columns. We need to find unique elements in matrix 
i.e, those elements which are not repeated in the matrix or those elements whose frequency is 1.

Examples:

Input :  20  15  30  2
         2   3   5   30
         6   7   6   8
Output : 3  20  5  7  8  15 

Input :  1  2  3  
         5  6  2
         1  3  5
         6  2  2
Output : No unique element in the matrix
*/
package com.matrix.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUniqueElementsInMatrix {

	static void UniqueElementsInMatrix(int mat[][])
	{
		int M = mat.length;
		int N = mat[0].length;
		
		Set<Integer> l = new HashSet<Integer>();
		List<Integer> m = new ArrayList<Integer>();
		
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(l.contains(mat[i][j]))
				{
					m.remove((Integer)mat[i][j]);
				}
				else
				{
					l.add(mat[i][j]);
					m.add(mat[i][j]);
				}
			}
		}
		
		if(m.size()>0)
			for(int i=0;i<m.size();i++)
				System.out.print(m.get(i)+" ");
		else
			System.out.println("No unique element in the matrix");	
	}

	public static void main(String[] args) {		
		int mat[][] = {{1, 2, 3, 20}, 
		               {5, 6, 20, 25},
		               {1, 3, 5, 6},
		               {6, 7, 8, 15}};
		
		UniqueElementsInMatrix(mat);
	}
}
//Time Complexity : O(MN)
