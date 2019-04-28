package com.binary.tree.myCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class DiagonalSumOfTree {
	
	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
	
	void diagonalSum(Node n,int vd) {
		
		if(n==null)
			return;
		
		if(hs.containsKey(vd)) {
			int temp = hs.get(vd) + n.data;
			hs.put(vd,temp);
		}
		else {
			hs.put(vd, n.data);
		}
		
		diagonalSum(n.left,vd+1);
		diagonalSum(n.right,vd);
	}
	
	void printSum() {
		
		Set<Entry<Integer,Integer>> es = hs.entrySet();
		
		Iterator<Entry<Integer,Integer>> itr = es.iterator();
		
		while(itr.hasNext()) {
			Entry<Integer,Integer> ent = itr.next();
			System.out.println("Level: "+ent.getKey()+" - "+ent.getValue());
		}
	}

	public static void main(String[] args) {
		DiagonalSumOfTree t = new DiagonalSumOfTree();
		
		t.root=t.new Node(1);
		t.root.left = t.new Node(2);
		t.root.right = t.new Node(3);
		t.root.left.left = t.new Node(9);
		t.root.left.right = t.new Node(6);
		t.root.right.left = t.new Node(4);
		t.root.right.right = t.new Node(5);
		t.root.right.left.left = t.new Node(12);
		t.root.right.left.right = t.new Node(7);
		t.root.left.right.left = t.new Node(11);
		t.root.left.left.right = t.new Node(10);
		
		/*
		t.root = t.new Node(1);
		t.root.left = t.new Node(2);
		t.root.right = t.new Node(3);
		t.root.left.left = t.new Node(4);
		t.root.left.right = t.new Node(5);
		t.root.right.left = t.new Node(6);
		t.root.right.right = t.new Node(7);
		*/
		
		t.diagonalSum(t.root,0);
		
		t.printSum();
	}
}