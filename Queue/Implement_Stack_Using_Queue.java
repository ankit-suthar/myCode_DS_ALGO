public class Implement_Stack_Using_Queue {
	Queue<Integer> queue=new LinkedList<Integer>();

	public void push(int item)
	{
		int l=queue.size();
		
		queue.add(item);
		
		for(int i=0;i<l;i++)
		{
			int x=queue.remove();
			queue.add(x);
		}
	}
	
	public int pop()
	{
		if(queue.isEmpty())
		{
			System.out.println("No elements");
		}
		return queue.remove();
	}
	
	public int top()
	{
		if(queue.isEmpty())
		{
			System.out.println("No elements");
		}
		return queue.peek();
	}
	
	public static void main(String[] args) {
		Implement_Stack_Using_Queue stack=new Implement_Stack_Using_Queue();
		
		stack.push(10);
		stack.push(20);
    System.out.println("Top element :" + stack.top());
    stack.pop();
    stack.push(30);
    stack.pop();
    System.out.println("Top element :" + stack.top());
	}
}
