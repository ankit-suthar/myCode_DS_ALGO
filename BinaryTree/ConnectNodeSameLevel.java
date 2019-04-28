package com.binary.tree.myCode;

public class ConnectNodeSameLevel {

	class Node{
		int data;
		Node left;
		Node right;
		Node nextRight;
		
		Node(int item){
			data=item;
			left=right=nextRight=null;
		}
	}
	
	Node root;
	
	void connectNodeSameLevel(Node n) {
		
		if(n==null)
			return;
		
		if(n.left!=null)
			n.left.nextRight=n.right;
		if(n.right!=null && n.nextRight!=null)
			n.right.nextRight=n.nextRight.left;
		
		connectNodeSameLevel(n.left);
		connectNodeSameLevel(n.right);
	}
	
	void printNodes(Node n) {
		
		if(n==null)
			return;
		
		System.out.print(n.data+" ");
			if(n.nextRight!=null)
				System.out.print("- "+n.nextRight.data+" ");
		System.out.println();
		printNodes(n.left);
		printNodes(n.right);
	}

	public static void main(String[] args) {
		ConnectNodeSameLevel tree = new ConnectNodeSameLevel();
		
		tree.root=tree.new Node(1);
		tree.root.left=tree.new Node(2);
		tree.root.right=tree.new Node(3);
		tree.root.left.left=tree.new Node(4);
		tree.root.left.right=tree.new Node(5);
		tree.root.right.left=tree.new Node(6);
		tree.root.right.right=tree.new Node(7);
		
		tree.connectNodeSameLevel(tree.root);
		tree.printNodes(tree.root);
	}
}