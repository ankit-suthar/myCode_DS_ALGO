package com.binary.tree.myCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class M_Ary_Tree_Level_Order {
	static Node root;
	
	static class Node
	{
		int data;
		ArrayList<Node> al;
		
		Node(int data)
		{
			this.data=data;
			al=new ArrayList<Node>();
		}
	}
	
	static void getLevelOrderTraversal(Node n)
	{
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(n);
		
		while(!q.isEmpty())
		{
			Node n1 = q.poll();
			
			System.out.print(n1.data+" ");
			
			for(int i=0;i<n1.al.size();i++)
				q.add(n1.al.get(i));
		}
	}

	public static void main(String[] args) {
		root = new Node(1); 
		
		root.al.add(new Node(2));		
		root.al.add(new Node(3));
		root.al.add(new Node(4));
		
		root.al.get(0).al.add(new Node(5));
		root.al.get(0).al.add(new Node(6));
		root.al.get(0).al.add(new Node(7));
		
		root.al.get(1).al.add(new Node(8));
		root.al.get(1).al.add(new Node(9));
		root.al.get(1).al.add(new Node(10));
		
		root.al.get(2).al.add(new Node(11));
		root.al.get(2).al.add(new Node(12));
		root.al.get(2).al.add(new Node(13));
		
		getLevelOrderTraversal(root);
	}
}