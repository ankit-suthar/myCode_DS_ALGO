package com.binary.tree.myCode;

public class RightView {
	
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
	
	void rightView(Node n,int level) {
		
		if(n==null)
			return;		
		
		/*if(visited==0) {
			System.out.println(n.data);
			visited=level;
		}
		else*/
		if(visited<level) {
			System.out.println(n.data);
			visited=level;
		}
		
		if(n.right!=null) {
			rightView(n.right,level+1);
		}
		if(n.left!=null) {
			rightView(n.left,level+1);
		}		
	}

	public static void main(String[] args) {
		RightView t = new RightView();
		
		t.root = t.new Node(12);
    t.root.left = t.new Node(10);
    t.root.right = t.new Node(30);
    t.root.right.left = t.new Node(25);
    t.root.right.right = t.new Node(40);
    t.root.left.left = t.new Node(11);
    t.root.left.left.left = t.new Node(12);
    t.root.left.left.left.right = t.new Node(13);
    
    t.rightView(t.root,1);
	}
}