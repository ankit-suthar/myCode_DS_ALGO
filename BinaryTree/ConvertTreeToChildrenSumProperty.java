package com.binary.tree.myCode;

public class ConvertTreeToChildrenSumProperty {

	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	
	void convertTreeToChildrenSum(Node n) {
		
		int rN=0,lN=0,diff;
		
		if(n==null || (n.left==null && n.right==null))
			return;
		
		convertTreeToChildrenSum(n.left);
		convertTreeToChildrenSum(n.right);
		
		if(n.left!=null)
			lN=n.left.data;
		
		if(n.right!=null)
			rN = n.right.data;
		
		diff = lN + rN - n.data;
		
		if(diff>0)
			n.data+=diff;
		
		if(diff<0)
			manageSum(n,-diff);
	}
	
	void manageSum(Node n,int d) {
		
		if(n.left!=null) {
			n.left.data+=d;
			manageSum(n.left,d);
		}
		else if(n.right!=null) {
			n.right.data+=d;
			manageSum(n.right,d);
		}
	}
	
	void printInOrder(Node n) {
		if(n==null)
			return;
		
		printInOrder(n.left);
		System.out.print(n.data+" ");
		printInOrder(n.right);
	}
	
	public static void main(String[] args) {
		ConvertTreeToChildrenSumProperty t = new ConvertTreeToChildrenSumProperty();
		
		t.root=t.new Node(50);
		t.root.left=t.new Node(7);
		t.root.right=t.new Node(2);
		t.root.left.left=t.new Node(3);
		t.root.left.right=t.new Node(5);
		t.root.right.left=t.new Node(1);
		t.root.right.right=t.new Node(30);
		t.root.left.left.left=t.new Node(1);
		t.root.left.left.right=t.new Node(2);
    
		t.printInOrder(t.root);
		System.out.println();
    t.convertTreeToChildrenSum(t.root);
    t.printInOrder(t.root);
	}
}