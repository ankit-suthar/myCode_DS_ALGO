/*
Given an N X M matrix, where ai, j = 1 denotes the cell is not empty, ai, j = 0 
denotes the cell is empty and ai, j = 2, denotes that you are standing at that cell. 
You can move vertically up or down and horizontally left or right to any cell which is empty. 
The task is to find the minimum number of steps to reach any boundary edge of the matrix. 
Print -1 if not possible to reach any of the boundary edges.

Note: There will be only one cell with value 2 in the entire matrix.

Examples:

Input: matrix[] = {1, 1, 1, 0, 1}
                  {1, 0, 2, 0, 1} 
                  {0, 0, 1, 0, 1}
                  {1, 0, 1, 1, 0} 
Output: 2
Move to the right and then move 
upwards to reach the nearest boundary
edge. 

Input: matrix[] = {1, 1, 1, 1, 1}
                  {1, 0, 2, 0, 1} 
                  {1, 0, 1, 0, 1}
                  {1, 1, 1, 1, 1}
Output: -1 
Approach: The problem can be solved using a Dynamic Programming approach. 
Given below is the algorithm to solve the above problem.

Find the position which has ‘2’ in the matrix.
Initialize two 2-D arrays of size same as the matrix. The dp[][] which stores the minimum 
number of steps to reach any index i, j and vis[][] marks if any particular i, j position has 
been visited or not previously.
Call the recursive function which has the base case as follows:
if the traversal at any point reaches any of the boundary edges return 0.
if the points position n, m has stored the minimum number of steps previously, then return dp[n][m].
Call the recurion again with all possible four moves that can be done from the position n, m. 
The moves are only possible if mat[n][m] is 0 and the position has not been visited previously.
Store the minimal of the four moves.
If the recursion returns any value less than 1e9, which we had stored as the maximum value, 
then there is an answer, else it does not have any answer.
*/
package com.matrix.matrix;

import java.util.LinkedList;
import java.util.Queue;

class point{
	int a,b;
	
	point(int a,int b){
		this.a=a;
		this.b=b;
	}
}

public class MinStepReachBoundaryEdges {	
	
	private static void checkDistance(int matrix[][]) {
		int i1=0,j1=0;
		int m = matrix.length;
		int n = matrix[0].length;
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(matrix[i][j]==2) {
					i1=i;
					j1=j;
					break;
				}
		
		int min = Integer.MAX_VALUE;
		
		int dp[][] = new int[m][n];		
		
		Queue<point> q = new LinkedList<point>();
		q.add(new point(i1,j1));
		dp[i1][j1] = 0;
		
		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		
		while(!q.isEmpty()) {
			point p = q.remove();
			int a = p.a;
			int b = p.b;
			
			if(a+1<m && matrix[a+1][b]==0 && !visited[a+1][b]){
				dp[a+1][b] = dp[a][b]+1;
				q.add(new point(a+1,b));
			}
			
			if(a-1>=0 && matrix[a-1][b]==0 && !visited[a-1][b]){
				dp[a-1][b] = dp[a][b]+1;
				q.add(new point(a-1,b));
			}
			
			if(b+1<m && matrix[a][b+1]==0 && !visited[a][b+1]){
				dp[a][b+1] = dp[a][b]+1;
				q.add(new point(a,b+1));
			}
			
			if(b-1>=0 && matrix[a][b-1]==0 && !visited[a][b-1]){
				dp[a][b-1] = dp[a][b]+1;
				q.add(new point(a,b-1));
			}
			
			visited[a][b]=true;
		}
		
		for(int i=0;i<n;i++)
			if(dp[0][i]>0 && dp[0][i]<min)
				min = dp[0][i];
		
		for(int i=0;i<n;i++)
			if(dp[m-1][i]>0 && dp[m-1][i]<min)
				min = dp[m-1][i];
		
		for(int i=1;i<m-1;i++)
			if(dp[i][0]>0 && dp[i][0]<min)
				min = dp[i][0];
		
		for(int i=1;i<m-1;i++)
			if(dp[i][n-1]>0 && dp[i][n-1]<min)
				min = dp[i][n-1];
		
		if(min==Integer.MIN_VALUE)
			min=-1;
		
		System.out.println(min);
	}
	
	public static void main(String[] args) {
		int matrix[][] = {
				{1, 1, 1, 0, 1},
        {1, 0, 2, 0, 1}, 
        {0, 0, 1, 0, 1},
        {1, 0, 1, 1, 0} 
        };

		checkDistance(matrix);
	}
}
//Time Complexity: O(N^2)
//Auxiliary Space: O(N^2)