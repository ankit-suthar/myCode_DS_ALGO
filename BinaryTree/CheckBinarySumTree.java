package com.binary.tree.myCode;

public class CheckBinarySumTree {
	
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
	
	int checkSumTree(Node n) {
		
		if(n==null)
			return 0;
		
		if(n.left==null && n.right==null)
			return n.data;

		int l=0,r=0;
		
		l = checkSumTree(n.left);
		r = checkSumTree(n.right);
		
		if(n.data==l+r) {
			return 2*(l+r);
		}
		else {
			return 0;
		}
	}

	public static void main(String[] args) {
		CheckBinarySumTree tree = new CheckBinarySumTree();
		
		tree.root = tree.new Node(26);
    tree.root.left = tree.new Node(10);
    tree.root.right = tree.new Node(3);
    tree.root.left.left = tree.new Node(4);
    tree.root.left.right = tree.new Node(6);
    tree.root.right.right = tree.new Node(3);
    
    /*
    tree.root = tree.new Node(34);
    tree.root.left = tree.new Node(10);
    tree.root.right = tree.new Node(7);
    tree.root.left.left = tree.new Node(4);
    tree.root.left.right = tree.new Node(6);
    tree.root.right.right = tree.new Node(3);
    tree.root.right.left = tree.new Node(4);    
    */
    
    if(tree.checkSumTree(tree.root)!=0)
    	System.out.println("Sum Tree");
    else
    	System.out.println("Not Sum Tree");
	}
}