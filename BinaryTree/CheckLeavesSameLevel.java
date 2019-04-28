package com.binary.tree.myCode;

public class CheckLeavesSameLevel {
	
	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	int level=0;
	
	boolean checkLeafAllLevel(Node n,int d) {
		
		if(n==null)
			return true;
		
		if(n.left==null && n.right==null) {
			
			if(level==0)
				level=d;
			else if(level==d)
				return true;
			else
				return false;
		}
		
		return checkLeafAllLevel(n.left,d+1) && checkLeafAllLevel(n.right,d+1);
	}

	public static void main(String[] args) {
		CheckLeavesSameLevel t = new CheckLeavesSameLevel();
		
		t.root = t.new Node(12);
    t.root.left = t.new Node(5);
    t.root.left.left = t.new Node(3);
    t.root.left.right = t.new Node(9);
    t.root.left.left.left = t.new Node(1);
    t.root.left.right.left = t.new Node(1);
    //t.root.left.right.left.right = t.new Node(4);
    
    if(t.checkLeafAllLevel(t.root,0))
    	System.out.println("Yes");
    else
    	System.out.println("No");
	}
}