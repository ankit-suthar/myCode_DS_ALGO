package com.binary.tree.myCode;

public class deleteTree {
	
	Node root;
	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int item){
			data=item;
			left=right=null;
		}
	}
	
	void deleteTree(Node n) {
		
		if(n==null)
			return;
		
		deleteTree(n.left);
		deleteTree(n.right);
		
		System.out.print(n.data+" ");
		n=null;		
	}

	public static void main(String[] args) {
		deleteTree tree = new deleteTree();
		
		tree.root=tree.new Node(1); 
		tree.root.left=tree.new Node(2);
		tree.root.right=tree.new Node(3);
		tree.root.left.left=tree.new Node(4);
		tree.root.left.right=tree.new Node(5);
		
		tree.deleteTree(tree.root);		
		tree.root=null;
	}
}