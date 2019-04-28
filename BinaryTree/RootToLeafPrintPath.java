package com.binary.tree.myCode;

public class RootToLeafPrintPath {

	class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	
	Node root;
	
	void pathArrayUtil(Node n,int arr[],int size) {
		
		if(n==null)
			return;
		
		arr[size] = n.data;
		size++;
		
		if(n.left==null && n.right==null)
			printPath(arr,size);
		
		pathArrayUtil(n.left,arr,size);
		pathArrayUtil(n.right,arr,size);
	}
	
	void printPath(int arr[],int n) {
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	void pathArray(Node n) {
		int arr[] = new int[1000];
		int size=0;
		pathArrayUtil(n,arr,size);
	}
	
	public static void main(String[] args) {
		RootToLeafPrintPath t = new RootToLeafPrintPath();
		
		t.root=t.new Node(1);
		t.root.left=t.new Node(2);
		t.root.right=t.new Node(3);
		t.root.left.left=t.new Node(4);
		//t.root.left.right=t.new Node(5);
		t.root.right.left=t.new Node(8);
		t.root.right.right=t.new Node(9);
		
		t.pathArray(t.root);
	}
}