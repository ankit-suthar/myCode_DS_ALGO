package com.linked.list;

public class PairwiseSwapElements {
	
	static Node head;
	
	private static class Node
	{
		int data;
		Node next;
		
		public Node(int d) 
		{
			data=d;
			next=null;			
		}
	}
		
	static void push(int d) 
	{
		Node n = new Node(d);
		n.next=head;
		head=n;		
	}
	
	static void printLL(Node n) 
	{	
		while(n!=null) 
		{
			System.out.print(n.data+" ");
			n=n.next;
		}
	}
    
	static void swap(Node n) 
	{
		Node temp=null,curr=null,prev=null;
		
		curr=n;
		while(curr!=null) 
		{
			temp=curr.next;
			curr.next=curr.next.next;
			prev=curr;
			temp.next=prev;
			curr=prev.next;			
		}			
	}
	
	public static void main(String[] args) {
		
		push(6);
		push(5);
		push(4);
		push(3);
		push(2);
		push(1);
		
		printLL(head);
		swap(head);
		System.out.println();
		printLL(head);		
	}
}