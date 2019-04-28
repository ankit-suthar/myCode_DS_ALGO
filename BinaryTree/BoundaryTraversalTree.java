package com.binary.tree.myCode;

public class BoundaryTraversalTree {

	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	
	void printLeft(Node n) {
		
		if(n==null)
			return;
		
		if(n.left!=null) {
			System.out.print(n.data+" ");
			printLeft(n.left);
		}
		else if(n.right!=null) {
			System.out.print(n.data+" ");
			printLeft(n.right);
		}
	}
	
	void printRight(Node n) {
		
		if(n==null)
			return;
		
		if(n.right!=null) {
			printRight(n.right);
			System.out.print(n.data+" ");
		}
		else if(n.left!=null) {
			printRight(n.left);
			System.out.print(n.data+" ");
		}
	}
	
	void printLeaf(Node n) {
		
		if(n==null)
			return;
		
		if(n.left==null && n.right==null)
			System.out.print(n.data+" ");
		
		printLeaf(n.left);
		printLeaf(n.right);
	}
	
	void printBoundary(Node n) {
		
		if(n==null)
			return;
		
		System.out.print(n.data+" ");
		
		printLeft(n.left);
		
		printLeaf(n);
		
		printRight(n.right);
	}
	
	public static void main(String[] args) {
		BoundaryTraversalTree t = new BoundaryTraversalTree();
		
		t.root = t.new Node(20);
    t.root.left = t.new Node(8);
    t.root.left.left = t.new Node(4);
    t.root.left.right = t.new Node(12);
    t.root.left.right.left = t.new Node(10);
    t.root.left.right.right = t.new Node(14);
    t.root.right = t.new Node(22);
    t.root.right.right = t.new Node(25);
    
    t.printBoundary(t.root);
	}
}