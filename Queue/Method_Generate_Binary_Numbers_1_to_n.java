import java.util.LinkedList;

public class Method_Generate_Binary_Numbers_1_to_n {

	public static void printBinaryNumbers(int n)
	{
		LinkedList<String> q=new LinkedList<String>();
	
		q.add("1");
		
		for(int i=0;i<n;i++)
		{
			String s = q.remove();
			
			System.out.println(s+" ");
			
			q.add(s+"0");
			q.add(s+"1");
		}
		
	}
	
	public static void main(String[] args) {
		int n=10;
		printBinaryNumbers(n);
	}
}
//Output
/*
1 
10 
11 
100 
101 
110 
111 
1000 
1001 
1010 
*/
