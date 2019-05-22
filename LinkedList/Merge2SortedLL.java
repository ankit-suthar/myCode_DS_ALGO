/*
The strategy here uses a temporary dummy node as the start of the result list. 
The pointer Tail always points to the last node in the result list, so appending new nodes is easy.
The dummy node gives tail something to point to initially when the result list is empty. 
This dummy node is efficient, since it is only temporary, and it is allocated in the stack. 
The loop proceeds, removing one node from either ‘a’ or ‘b’, and adding it to tail. 
When we are done, the result is in dummy.next.
*/
package com.linked.list;

public class Merge2SortedLL {
	
Node head1;
Node head2;

	private class Node{
		int data;
		Node next;
		
		public Node(int d) {
			data=d;
			next=null;			
		}
	}
	
	Node merge(Node h1,Node h2){
		
		Node dummy = new Node(0);
		Node tail=dummy;
		
		while(true) {
			
			if(h1==null) {
				tail.next=h2;
				break;
			}
			
			if(h2==null) {
				tail.next=h1;
				break;
			}
			
			if(h1.data>=h2.data) {
				tail.next=h2;
				h2=h2.next;
			}
			else{
				tail.next=h1;
				h1=h1.next;
			}
			tail=tail.next;
		}
	return dummy.next;		
	}
	
	void printLL(Node n) {
		while(n!=null) {
			System.out.print(n.data+" ");
			n=n.next;
		}
	}
	
	public static void main(String[] args) {
		Merge2SortedLL llist1 = new Merge2SortedLL(); 
	      
	    // Node head1 = new Node(5); 
	    llist1.head1 = llist1.new Node(5); 
	    llist1.head1.next = llist1.new Node(10); 
	    llist1.head1.next.next = llist1.new Node(15); 
	      
	    // Node head2 = new Node(2);
	    llist1.head2 = llist1.new Node(2); 
	    llist1.head2.next = llist1.new Node(3); 
	    llist1.head2.next.next = llist1.new Node(20);
	    
	    System.out.println("head1 : ");
	    llist1.printLL(llist1.head1);
	    System.out.println();
	    System.out.println("head2 : ");
	    llist1.printLL(llist1.head2);
	    System.out.println();
	    
	    Node n = llist1.merge(llist1.head1, llist1.head2);
	    
	    System.out.println("New node : ");
	    llist1.printLL(n);
	}
}