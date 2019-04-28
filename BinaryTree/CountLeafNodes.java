package com.binary.tree.myCode;

public class CountLeafNodes {
	
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
	int count = 0;
	
	void countLeavesNode(Node n) {
		
		if(n==null)
			return;
		
		if(n.left==null && n.right==null)
			count++;
		
		countLeavesNode(n.left);
		countLeavesNode(n.right);
	}
	
	public static void main(String[] args) {
		CountLeafNodes tree=new CountLeafNodes();
		tree.root=tree.new Node(1);
		tree.root.left=tree.new Node(2);
		tree.root.right=tree.new Node(3);
		tree.root.left.left=tree.new Node(4);
		tree.root.left.right=tree.new Node(5);

		tree.countLeavesNode(tree.root);
		System.out.println("Total Leaf Nodes: "+ tree.count);
	}
}