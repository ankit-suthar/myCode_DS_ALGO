package com.binary.tree.myCode;

public class MirrorTree {
	
	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	
	Node mirrorTree(Node n) {
		
		if(n==null)
			return null;		
		
		Node left = mirrorTree(n.left);
		Node right = mirrorTree(n.right);
		
		Node temp = n.left;
		n.left = n.right;
		n.right = temp;
		return n;
	}
	
	void printTree(Node n) {		
		
		if(n==null)
			return;
		
		System.out.print(n.data+" ");
		printTree(n.left);
		printTree(n.right);
	}

	public static void main(String[] args) {
		MirrorTree t = new MirrorTree();
		
		t.root=t.new Node(1);
		t.root.left=t.new Node(2);
		t.root.right=t.new Node(3);
		t.root.left.left=t.new Node(4);
		t.root.left.right=t.new Node(5);
    
		t.printTree(t.root);
    t.root = t.mirrorTree(t.root);
    System.out.println();
    t.printTree(t.root);
	}
}