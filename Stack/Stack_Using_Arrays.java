public class Stack_Using_Arrays {

	static final int MAX=100;
	int top;
	int a[]=new int[MAX];  // Maximum size of Stack
	
	Stack_Using_Arrays(){
		top=-1;
	}
		
	boolean push(int n){
		if(top>=MAX){
			System.out.println("Stack overflow");
			return false;
		}
		else{
			a[++top]=n;
			return true;
		}
	}
	
	int pop(){
		if(top<0){
			System.out.println("Stack Underflow");
			return 0;
		}
		else{
			int n=a[top--];
			return n;
		}
	}
	
	int peek(){
		if(top<0){
			System.out.println("Stack Underflow");
			return 0;
		}
		
		if(top>=MAX){
			int test=MAX-1;
			int n=a[test];
			return n;
		}
		else{
			int n=a[top];
			return n;
		}	
	}
	
	public static void main(String[] args) {
		Stack_Using_Arrays s=new Stack_Using_Arrays();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop()+" Popped from stack");
		System.out.println("Top item is "+s.peek());
	}
}
