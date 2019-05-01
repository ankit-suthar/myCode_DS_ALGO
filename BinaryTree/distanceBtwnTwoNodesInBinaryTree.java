//Distance between two nodes of binary tree

package com.binary.tree.myCode;

public class distanceBtwnTwoNodesInBinaryTree {
	
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

	Node getLCA(Node n, int a,int b)
	{
		if(n==null)
			return null;
		
		if(n.data==a || n.data==b)
			return n;
		
		Node left = getLCA(n.left,a,b);
		Node right = getLCA(n.right,a,b);
		
		if(left==null && right==null)
			return null;
		
		if(left!=null && right!=null)
			return n;
		
		return (left!=null)?left:right;
	}
	
	int getDistanceFromRoot(Node n, int data, int level)
	{
		if(n==null)
			return 0;
		
		if(n.data==data)
			return level;
		
		int d1 = getDistanceFromRoot(n.left,data,level+1);
		
		int d2 = getDistanceFromRoot(n.right,data,level+1);
		
		if(d1==0 && d2==0)
			return d1;
		
		return (d1!=0)?d1:d2;
	}
	
	public static void main(String[] args) {
		distanceBtwnTwoNodesInBinaryTree l = new distanceBtwnTwoNodesInBinaryTree();
		
		l.root = l.new Node(3);
		
		l.root.left = l.new Node(6);
		l.root.right = l.new Node(8);
		
		l.root.left.left = l.new Node(2);
		l.root.left.right = l.new Node(11);
		
		l.root.left.right.left = l.new Node(9);
		l.root.left.right.right = l.new Node(5);
		
		l.root.right.right = l.new Node(13);
		l.root.right.right.left = l.new Node(7);
		
		int a = 9;
		int b = 13;
		
		//LCA : Lowest Common Ancestor
		
		Node n = l.getLCA(l.root,a,b);
		
		int d1 = l.getDistanceFromRoot(l.root,a,0);
		
		int d2 = l.getDistanceFromRoot(l.root,b,0);
		
		int lca = l.getDistanceFromRoot(l.root,n.data,0);
		
		int d = d1+d2 - 2*lca;
		
		System.out.println("Distance between node "+a+" and node "+b+" is "+d);
	}
}
//Time Complexity: O(n)