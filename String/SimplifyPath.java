/*
Input: "/home/" Output: "/home"
Input: "/a/./b/../../c/" Output: "/c"
Input: "/../" Output: "/"
Input: "/home//foo/" Output: "/home/foo"
*/

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
	
	static String simplyifyPath(String str)
	{
		Stack<String> st = new Stack<String>();
		str = str.substring(0, str.length()-1);
		int n = str.length();
		int start=0;
		
		for(int i=1;i<n;i++)
		{
			if(str.charAt(i)=='/')
			{
				st.push(str.substring(start,i));
				start=i;
			}
			else if(i==n-1)
				st.push(str.substring(start));
		}
		
		int back=0;
		LinkedList<String> l = new LinkedList<String>();
		
		while(!st.isEmpty())
		{
			String s = st.pop();
			
			if(s.equals("/.") || s.equals("/"))
			{
				
			}
			else if(s.equals("/.."))
				back++;
			else
				if(back>0)
					back--;
				else
					l.push(s);
		}
		
		if(l.isEmpty())
			return "/";
		
		StringBuffer sb = new StringBuffer();
		
		while(!l.isEmpty())
		{
			String s = l.pop();
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "/home//foo/";

	 System.out.println(simplyifyPath(str));	
	}
}
