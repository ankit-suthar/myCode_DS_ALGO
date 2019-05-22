package com.linked.list;


public class FindMiddleElementsLL {
	
static Node head;

	private static class Node{
		int data;
		Node next;
		
		public Node(int d) {
			data=d;
			next=null;			
		}
	}
	
	static void findMiddle(Node n) {
		int c=0;
		
		while(n!=null) {
			c++;
			n=n.next;
		}
		n=head;
		int i;
		for(i=0;i<=(c/2)-1;i++)
			n=n.next;
		
		System.out.println(n.data);	
	}

	public static void main(String[] args) {
		head=new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		findMiddle(head);
	}
}
