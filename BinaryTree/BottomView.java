package com.binary.tree.myCode;

import java.util.HashMap;

public class BottomView {
	
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
	int max=0,min=0;
	HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
	
	void bottomView(Node n,int vd) {
		
		if(n==null)
			return;		
	
			hs.put(vd, n.data);
			
			if(vd>max)
				max=vd;
			
			if(vd<min)
				min=vd;
	
			bottomView(n.left,vd-1);
			bottomView(n.right,vd+1);		
	}
	
	void printTree() {
		/*
		Set<Entry<Integer,Integer>> s = hs.entrySet();
		 
		Iterator<Entry<Integer,Integer>> itr = s.iterator();
		
		while(itr.hasNext()) {
			Entry<Integer,Integer> e = itr.next();
			System.out.println(e.getKey()+" "+e.getValue());
		}
		*/
		
		for(int i=min;i<=max;i++) {
			System.out.println(i+" "+hs.get(i));
		}
	}

	public static void main(String[] args) {
		BottomView t = new BottomView();
		
		t.root = t.new Node(12);
    t.root.left = t.new Node(10);
    t.root.right = t.new Node(30);
    t.root.right.left = t.new Node(25);
    t.root.right.right = t.new Node(40);
    t.root.left.left = t.new Node(11);
    t.root.left.left.left = t.new Node(12);
    t.root.left.left.left.right = t.new Node(13);
    
    t.bottomView(t.root,0);
    t.printTree();
	}
}