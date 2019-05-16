public class Stack_Using_LinkedList {
	
	int top;
	Node root;
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	Stack_Using_LinkedList(){
		top=-1;
	}
	
	int peek(){
		int n=root.data;
		return n;
	}

	int pop(){
		int n=root.data;
		root=root.next;
		return n;		
	}

	void push(Node node,int new_data){
		
		Node new_node=new Node(new_data);
		new_node.next=root;
		root=new_node;
		
		System.out.println(root.data+" pushed to stack");
	}
	
	
	
	public static void main(String[] args) {
		Stack_Using_LinkedList s=new Stack_Using_LinkedList();
		
		s.push(s.root,10);
		s.push(s.root,20);
		s.push(s.root,30);
		
		System.out.println("\n"+s.pop()+" popped from the stack\n");
		System.out.println(s.peek()+" is the peek of the stack");
	}
}
