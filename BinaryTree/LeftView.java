package com.binary.tree.myCode;

public class LeftView {
	
	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	int visited=0;
	
	void leftView(Node n,int level) {
		
		if(n==null)
			return;		
		
		if(visited<level) {
			System.out.println(n.data);
			visited=level;
		}
		
		if(n.left!=null) {
			leftView(n.left,level+1);
		}
		if(n.right!=null) {
			leftView(n.right,level+1);
		}		
	}

	public static void main(String[] args) {
		LeftView t = new LeftView();
		
		t.root = t.new Node(12);
    t.root.left = t.new Node(10);
    t.root.right = t.new Node(30);
    t.root.right.left = t.new Node(25);
    t.root.right.right = t.new Node(40);
    t.root.left.left = t.new Node(11);
    t.root.left.left.left = t.new Node(12);
    t.root.left.left.left.right = t.new Node(13);
    
    t.leftView(t.root,1);
	}
}