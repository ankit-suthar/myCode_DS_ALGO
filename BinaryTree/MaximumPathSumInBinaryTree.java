/*
Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

Example:

Input: Root of below tree
       1
      / \
     2   3
Output: 6  (1+2+3)

Input:
													10
												/    \
											/        \
										 2          10
									 /  \           \
								 /      \           \
								20       1          -25
								                   /   \
								                 /       \
								                3         4
Output: 42 (20+2+10+10)								            

There can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child
*/
package com.binary.tree;

public class MaximumPathSumInBinaryTree {

	Node root;
	
	class Node
	{
		int data;
		Node left,right;
		
		Node(int data)
		{
			this.data=data;
			left=right=null;
		}
	}
	
	static int res = Integer.MIN_VALUE;
	
	int getMaxSumPath(Node n)
	{
		if(n==null)
			return 0;
		
		int l = getMaxSumPath(n.left);
		int r = getMaxSumPath(n.right);
		
		int maxVal = Math.max(Math.max(l, r)+n.data,n.data);
		
		int maxTop = Math.max(maxVal, l+r+n.data);
		
		res = Math.max(res, maxTop);
		
		return maxVal;
	}
	
	public static void main(String[] args) {
		MaximumPathSumInBinaryTree m = new MaximumPathSumInBinaryTree();
		
		m.root = m.new Node(10);
		
		m.root.left = m.new Node(2);
		m.root.right = m.new Node(10);
		
		m.root.left.left = m.new Node(20);
		m.root.left.right = m.new Node(1);
		
		m.root.right.right = m.new Node(-25);
		
		m.root.right.right.left = m.new Node(3);
		m.root.right.right.right = m.new Node(4);
		
		m.getMaxSumPath(m.root);
		System.out.println("Maximum Path Sum is: "+res);
	}
}
//Time Complexity: O(n) where n is number of nodes in Binary Tree.