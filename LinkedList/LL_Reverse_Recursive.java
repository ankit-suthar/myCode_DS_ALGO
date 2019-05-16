public class LL_Reverse_Recursive {
	static Node head;

	static class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	void reverse_recursive(Node curr){
		
		if(curr==null) return;
		
		reverse_recursive(curr.next);
		
		System.out.println(curr.data+" ");
	}
	
	public void printlist(Node node){
		while(node!=null){
			System.out.println(node.data+" ");
			node=node.next;
		}
	}
	
	public static void main(String[] args) {
		LL_Reverse_Recursive llist=new LL_Reverse_Recursive();
		
		head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next=new Node(4);
		head.next.next.next=new Node(5);
		
		System.out.println("Original Linked list ");
		llist.printlist(head);
		System.out.println("");
		System.out.println("");
		System.out.println("Reversed linked list ");
		llist.reverse_recursive(head);
	}
}
