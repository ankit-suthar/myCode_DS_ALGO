/*
We see that S[i] on day i can be easily computed if we know the closest day preceding i, 
such that the price is greater than on that day than the price on day i. If such a day 
exists, let’s call it h(i), otherwise, we define h(i) = -1.
The span is now computed as S[i] = i – h(i). See the following diagram.

To implement this logic, we use a stack as an abstract data type to store the days i, h(i), h(h(i)) 
and so on. When we go from day i-1 to i, we pop the days when the price of the stock was less than 
or equal to price[i] and then push the value of day i back into the stack.
*/
package com.array.array;

import java.util.Stack;

public class StockSpanProblemUsingStack {
	
	static void stockSpan(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int s[] = new int[arr.length];
		s[0]=1;
		st.push(0);
		
		for(int i=1;i<arr.length;i++) {	
			while(!st.isEmpty() && arr[st.peek()]<arr[i])
				st.pop();
			
			s[i] = (st.isEmpty())?(i+1):(i-st.peek());
				
			st.push(i);
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(s[i]+" ");
	}

	public static void main(String[] args) {
		int arr[]= {10,4,5,90,120,80};
		
		stockSpan(arr);
	}
}
//Time Complexity: O(n). It seems more than O(n) at first look. 
//If we take a closer look, we can observe that every element of 
//array is added and removed from stack at most once. So there are total 
//2n operations at most. Assuming that a stack operation takes O(1) time, 
//we can say that the time complexity is O(n).