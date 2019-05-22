package com.linked.list;

public class Intersection2LL {
	
	 Node head1;
   Node head2;

	private class Node{
		int data;
		Node next;
		
		public Node(int d) 
		{
			data=d;
			next=null;			
		}
	}
	
	int getcount(Node n) 
	{
		int c=0;
		
		while(n!=null) 
		{
			c++;
			n=n.next;			
		}
		return c;
	}
	
	Node traverse(int d, Node n1, Node n2) 
	{	
		for(int i=0;i<d;i++)
			n1=n1.next;
		return n1;
	}

	public static void main(String[] args) 
	{
		Intersection2LL list = new Intersection2LL();
				list.head1 = list.new Node(3); 
        list.head1.next = list.new Node(6); 
        list.head1.next.next = list.new Node(15); 
        list.head1.next.next.next = list.new Node(15); 
        list.head1.next.next.next.next = list.new Node(30); 
        
        list.head2 = list.new Node(10); 
        list.head2.next = list.new Node(15); 
        list.head2.next.next = list.new Node(30);
        
        int c1 = list.getcount(list.head1);
        int c2 = list.getcount(list.head2);
        
        int d;
        Node ans;
        
        if(c1>c2) 
        {
        	d = c1-c2;
        	ans = list.traverse(d,list.head1,list.head2);
        }
        else 
        {
        	d=c2-c1;
        	ans = list.traverse(d,list.head2,list.head1);
        }
        System.out.println("The intersection node is: "+ans.data);
	}
}