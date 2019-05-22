package com.linked.list;


public class AddTwoNumbers {

static Node head1;
static Node head2;
static Node head3;
	
	private static class Node{
		int data;
		Node next;
		
		public Node(int d) {
			data=d;
			next=null;			
		}
	}
	
	static void printLL(Node n) {
		
		while(n!=null) {
			System.out.print(n.data+" ");
			n=n.next;
		}
	}
	
	static Node reverseLL(Node n) {
		Node curr=n;
		Node next=null;
		Node prev=null;
		
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}	
		return prev;
	}
	
    static int carry=0; 
	
    static void addsamesize(Node n, Node m)  
    {
		
    	while(n!=null || m!=null) {
			
    		int sum=(n != null ? n.data:0)+(m != null ? m.data:0)+carry;
    		carry=sum/10;
    		sum=sum%10;
			
    		Node newNode=new Node(sum);
    		newNode.next=head3;
    		head3=newNode;
			
    		if(n!=null)
    			n=n.next;
			
    		if(m!=null)
    			m=m.next;
    	}
    }
	
	
	public static void main(String[] args) {
		
		head1 = new Node(4);
		Node n1 = new Node(5);
		n1.next=head1;
		head1=n1;
		
		head2 = new Node(3);
		Node n2 = new Node(4);
		n2.next=head2;
		Node n3 = new Node(5);
		n3.next=n2;
		head2=n3;
		
		printLL(head1);
		System.out.println();
		printLL(head2);
		System.out.println();
		
		addsamesize(head1,head2);
		
		Node head4 = reverseLL(head3);
		printLL(head4);
		
	}
}
