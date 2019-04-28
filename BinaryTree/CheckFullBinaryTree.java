package com.binary.tree.myCode;

public class CheckFullBinaryTree {
	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int item){
			data=item;
			left=right=null;
		}
	}
	Node root;

	boolean checkBinaryTree(Node n) {
		
		if(n==null)
			return true;
		
		if(n.left==null && n.right==null)
			return true;
		
		if(n.left==null || n.right==null)
			return false;
		
		return checkBinaryTree(n.left) && checkBinaryTree(n.right);				
	}

	public static void main(String[] args) {
		CheckFullBinaryTree tree = new CheckFullBinaryTree();
		
		tree.root=tree.new Node(1);
		tree.root.left=tree.new Node(2);
		tree.root.right=tree.new Node(3);
		//tree.root.right.left=tree.new Node(6);
		tree.root.left.left=tree.new Node(4);
		tree.root.left.right=tree.new Node(5);   
    
		if(tree.root==null) {
			System.out.println("Full Binary Tree");
		}    
		else if(tree.checkBinaryTree(tree.root)) {
			System.out.println("Full Binary Tree");
		}    	
    else {
    	System.out.println("Not Full Binary Tree");
    }
	}

}
