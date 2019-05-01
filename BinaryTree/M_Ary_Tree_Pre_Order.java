/*
Given an n-ary tree, print preorder traversal of it.
1) Create an empty stack to store nodes.
2) Push the root node to the stack.
3) Run a loop while the stack is not empty
….a) Pop the top node from stack.
….b) Print the popped node.
….c) Store all the children of popped node onto the stack. We must store children from right to left so that leftmost node is popped first.
4) If stack is empty then we are done.
*/
package com.binary.tree.myCode;

import java.util.ArrayList;

public class M_Ary_Tree_Pre_Order {
	static Node root;
	
	/*
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
	*/
	
	static class Node
	{
		char data;
		ArrayList<Node> al;
		
		Node(char data)
		{
			this.data=data;
			al=new ArrayList<Node>();
		}
	}
	
	static void getLevelOrderTraversal(Node n)
	{
		
		System.out.print(n.data+" ");
		
		for(int i = 0;i<n.al.size();i++)
		{
			getLevelOrderTraversal(n.al.get(i));
		}	
	}

	public static void main(String[] args) {
		/*
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
		*/
		
		root = new Node('A'); 
		
		root.al.add(new Node('B'));		
		root.al.add(new Node('F'));
		root.al.add(new Node('D'));
		root.al.add(new Node('E'));
		
		root.al.get(0).al.add(new Node('K'));
		root.al.get(0).al.add(new Node('J'));
		
		root.al.get(2).al.add(new Node('G'));
		
		root.al.get(3).al.add(new Node('C'));
		root.al.get(3).al.add(new Node('H'));
		root.al.get(3).al.add(new Node('I'));
		
		root.al.get(0).al.get(0).al.add(new Node('N'));
		root.al.get(0).al.get(0).al.add(new Node('M'));
    
		root.al.get(3).al.get(2).al.add(new Node('L'));		
		
		getLevelOrderTraversal(root);
	}
}
//Time Complexity: O(n)