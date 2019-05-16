public class LL_Delete_Node {

	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	public void push(int new_data){
			
		if(head==null){
			head=new Node(new_data);
			return;
		}
		Node new_node=new Node(new_data);
		
		new_node.next=head;
		head=new_node;
		return;		
	}
	
	public void deleteNode(int key){
		Node temp = head, prev = null;
		
		while(temp!=null && temp.data!=key){
			prev=temp;
			temp=temp.next;
		}
		
		if(temp==null){ return; }
		
		prev.next=temp.next;
		}
	
	public void printlist(){
		Node tempN=head;
		while(tempN!=null){
			System.out.println(tempN.data+" ");
			tempN=tempN.next;
		}
	}
	
	public static void main(String[] args) {
		
		LL_Delete_Node llist= new LL_Delete_Node();
		
		llist.push(7);
		llist.push(1);
		llist.push(3);
		llist.push(2);
		
		System.out.println("\nCreated Linked list is:");
		llist.printlist();
		
		llist.deleteNode(1);
		
		System.out.println("\nLinked List after Deletion at position 4:");
    llist.printlist();		
	}
}
