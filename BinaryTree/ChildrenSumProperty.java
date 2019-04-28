package com.binary.tree.myCode;

public class ChildrenSumProperty {
	
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
	
	boolean childrenSumProperty(Node n){
		
		if(n==null)
			return true;
		
		if(n.left==null && n.right==null)
			return true;
		
		int l=0,r=0;

		if(n.left!=null)
			l = n.left.data;
		if(n.right!=null)
			r = n.right.data;
		
		return (n.data==l+r) && childrenSumProperty(n.left) && childrenSumProperty(n.right);
	}

	public static void main(String[] args) {
		ChildrenSumProperty tree = new ChildrenSumProperty();
		
		tree.root = tree.new Node(10);
    tree.root.left = tree.new Node(8);
    tree.root.right = tree.new Node(2);
    tree.root.left.left = tree.new Node(3);
    tree.root.left.right = tree.new Node(5);
    tree.root.right.right = tree.new Node(2);
    
    if(tree.childrenSumProperty(tree.root))
    	System.out.println("Yes");
    else
    	System.out.println("No");
	}
}