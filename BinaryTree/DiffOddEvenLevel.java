package com.binary.tree.myCode;

public class DiffOddEvenLevel {
	
	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	int diff=0;
	
	int getDiff(Node n) {
		boolean flag=true;
		
		int h = height(n);
		
		for(int i=1;i<=h;i++) {
			calculate(n,i,flag);
			flag=!flag;
		}	
		return diff;
	}
	
	int height(Node n) {
		
		if(n==null)
			return 0;
		
		return 1+ Math.max(height(n.left),height(n.right));
	}
	
	void calculate(Node n,int level,boolean flag) {
		
		if(n==null)
			return;
		
		if(level==1) {		
			diff = (flag) ? (diff+n.data) : (diff-n.data);
		}
		else if(level>1) {
			calculate(n.left,level-1,flag);
			calculate(n.right,level-1,flag);
		}
	}

	public static void main(String[] args) {
		DiffOddEvenLevel t = new DiffOddEvenLevel();
		
		t.root = t.new Node(5);
    t.root.left = t.new Node(2);
    t.root.right = t.new Node(6);
    t.root.left.left = t.new Node(1);
    t.root.left.right = t.new Node(4);
    t.root.left.right.left = t.new Node(3);
    t.root.right.right = t.new Node(8);
    t.root.right.right.right = t.new Node(9);
    t.root.right.right.left = t.new Node(7);
    
    t.getDiff(t.root);
    System.out.println(t.diff);
	}
}