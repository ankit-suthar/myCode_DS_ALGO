package com.linked.list;

public class CheckLLPalindrome {
	
	static Node head;

	private static class Node{
		int data;
		Node next;
		
		public Node(int d) {
			data=d;
			next=null;			
		}
	}
	
	static boolean checkPalindrome(Node n){
		String s="";
		
		while(n!=null) {
			s+=Integer.toString(n.data);
			n=n.next;
		}
		StringBuilder sb = new StringBuilder(s);
		String s1=sb.reverse().toString();
		if(s.equals(s1))
			return true;
		return false;		
	}
	

	public static void main(String[] args) {
		head=new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		/*head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);*/
		
		System.out.println(checkPalindrome(head));
	}
}
