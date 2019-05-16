public class MergeSortLinkedLists {
	Node head;
	
	private class Node{
		int data;
		Node next;
		
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	void push(int d) {
		Node n = new Node(d);
		n.next=head;
		head=n;		
	}
	
	Node sortedMerge(Node a,Node b) {
		Node result=null;
		
		if(a==null)
			return b;
		
		if(b==null)
			return a;
		
		if(a.data<b.data){
			result=a;
			result.next=sortedMerge(a.next,b);
		}
		else {
			result=b;
			result.next=sortedMerge(a,b.next);
		}
		return result;
	}
	
	Node mergeSort(Node n) {
		
		if(n==null || n.next==null)
			return n;
		
		Node middle = getMiddle(n);
		Node nextOfMiddle = middle.next;
		middle.next=null;
		
		Node left = mergeSort(n);
		Node right = mergeSort(nextOfMiddle);
		
		Node sortedList = sortedMerge(left,right);
		return sortedList;	
	}	
	
	Node getMiddle(Node h)
	{
		if(h==null||h.next==null)
			return h;
		
		Node fast=h.next;
		Node slow=h;
		
		while(fast!=null) {
			fast=fast.next;
			
			if(fast!=null)
			{
				slow=slow.next;
				fast=fast.next;
			}
		}
		return slow;
  }
	
	void printList(Node n) {
		while(n!=null) {
			System.out.print(n.data+" ");
			n=n.next;
		}
	}

	public static void main(String[] args) {
		MergeSortLinkedLists li=new MergeSortLinkedLists();
		
		li.push(15); 
    li.push(10); 
    li.push(5); 
    li.push(20); 
    li.push(3); 
    li.push(2); 
    System.out.println("Linked List without sorting is :"); 
    li.printList(li.head); 

    // Apply merge Sort
    li.head = li.mergeSort(li.head);
    System.out.print("\nSorted Linked List is: \n"); 
    li.printList(li.head);
	}
}
//Time Complexity: O(n Log n)
