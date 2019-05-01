package com.binary.tree.myCode;

public class LowestCommonAncestor {

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
	public static void main(String[] args) {
		LowestCommonAncestor l = new LowestCommonAncestor();
		
		l.root = l.new Node(3);
		
		l.root.left = l.new Node(6);
		l.root.right = l.new Node(8);
		
		l.root.left.left = l.new Node(2);
		l.root.left.right = l.new Node(11);
		
		l.root.left.right.left = l.new Node(9);
		l.root.left.right.right = l.new Node(5);
		
		l.root.right.right = l.new Node(13);
		l.root.right.right.left = l.new Node(7);
		
		Node n = l.getLCA(l.root,9,8);
		
		System.out.println(n.data);
	}
}
//Time Complexity:O(n)