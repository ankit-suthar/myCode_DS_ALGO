package com.binary.tree.myCode;

public class PrintNodeKDistanceFromRoot {
	
	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	
	void printNodekDistance(Node n,int l) {
		
		if(n==null)
			return;
		
		if(l==1)
			System.out.print(n.data+" ");
		else if(l>1) {
			printNodekDistance(n.left,l-1);
			printNodekDistance(n.right,l-1);
		}
	}
	
	public static void main(String[] args) {
		PrintNodeKDistanceFromRoot t = new PrintNodeKDistanceFromRoot();
		int l = 2;
		
		t.root = t.new Node(1);
		t.root.left = t.new Node(2);
		t.root.right = t.new Node(3);
		t.root.left.left = t.new Node(4);
		t.root.left.right = t.new Node(5);
		t.root.right.left = t.new Node(8);

		System.out.println("Node at Level: "+l);
		t.printNodekDistance(t.root,l);		
	}
}