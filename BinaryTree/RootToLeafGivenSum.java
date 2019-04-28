package com.binary.tree.myCode;

public class RootToLeafGivenSum {
	
	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	
	boolean hasSumPath(Node n,int sum) {
		
		if(n==null)
			return false;
		
		sum = sum-n.data;
		
		if(sum==0 && n.left==null && n.right==null)/*This condition for root to leaf sum only not in between*/  //if(sum==0)
			return true;
		else if(sum<0)
			return false;
		
			return hasSumPath(n.left,sum) || hasSumPath(n.right,sum);
	}

	public static void main(String[] args) {
		RootToLeafGivenSum t = new RootToLeafGivenSum();
		int sum = 20;
		
		t.root=t.new Node(10);
		t.root.left=t.new Node(8);
		t.root.right=t.new Node(2);
		t.root.left.left=t.new Node(3);
		t.root.left.right=t.new Node(4);
		t.root.right.left=t.new Node(2);
		
		if(t.hasSumPath(t.root,sum))
			System.out.println("Yes");
		else
			System.out.println("No"); 
	}
}