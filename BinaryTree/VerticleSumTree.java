package com.binary.tree.myCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class VerticleSumTree {
	
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
	
	void verticalSumTree(Node n,int vd) {
		
		if(n==null)
			return;		
		
		if(hs.containsKey(vd)) {
			int sum = hs.get(vd) + n.data;
			hs.put(vd, sum);
		}
		else {
			hs.put(vd, n.data);
		}
		
		verticalSumTree(n.left,vd-1);
		verticalSumTree(n.right,vd+1);
	}
	
	void printTree() {		
		
		Set<Entry<Integer,Integer>> s = hs.entrySet();
		Iterator<Entry<Integer,Integer>> itr = s.iterator();
		
		while(itr.hasNext()) {
			Entry<Integer,Integer> ent = itr.next();
			System.out.println(ent.getKey()+" "+ent.getValue());
		}
	}

	public static void main(String[] args) {
		VerticleSumTree t = new VerticleSumTree();
		
		t.root = t.new Node(1);
    t.root.left = t.new Node(2);
    t.root.right = t.new Node(3);
    t.root.left.left = t.new Node(4);
    t.root.left.right = t.new Node(5);
    t.root.right.left = t.new Node(6);
    t.root.right.right = t.new Node(7);
    t.root.right.left.right = t.new Node(8);
    t.root.right.right.right = t.new Node(9);
    
    t.verticalSumTree(t.root,0);
    t.printTree();
	}
}