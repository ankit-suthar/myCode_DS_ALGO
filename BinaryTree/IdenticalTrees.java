package com.binary.tree.myCode;

public class IdenticalTrees {
	
	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root1;
	Node root2;
	
	boolean checkIdenticalTree(Node n1,Node n2) {
		
		if(n1==null && n2==null)
			return true;		
		
		if(n1==null || n2==null)
			return false;
		
		return checkIdenticalTree(n1.left,n2.left) && checkIdenticalTree(n1.right,n2.right);
	}

	public static void main(String[] args) {
		IdenticalTrees t = new IdenticalTrees();
		
		t.root1 = t.new Node(1);
    t.root1.left = t.new Node(2);
    t.root1.right = t.new Node(3);
    t.root1.left.left = t.new Node(4);
    t.root1.left.right = t.new Node(5);

    t.root2 = t.new Node(1);
    t.root2.left = t.new Node(2);
    t.root2.right = t.new Node(3);
    t.root2.left.left = t.new Node(4);
    t.root2.left.right = t.new Node(5);
    //t.root2.right.left = t.new Node(6);
    
    if(t.checkIdenticalTree(t.root1,t.root2))
    	System.out.println("Identical");
    else
    	System.out.println("Not");
	}
}