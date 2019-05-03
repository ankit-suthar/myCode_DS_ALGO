/*
Given a set of strings, find the longest common prefix.

Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"

Suppose you have the input strings as- “geeksforgeeks”, “geeks”, “geek”, “geezer”, “x”.
Now there is no common prefix string of the above strings. 
Here, there is no common prefix string by traversing all the strings. 
If we use this algorithm, then in the first iteration itself we will come to know that there is 
no common prefix string, as we don’t go further to look for the second character of each strings.
*/
package com.array.array;

public class LongestCommonPrefixUsingWordByWordMatching_1 {
	
	static int getMinLength(String arr[])
	{
		int min = arr[0].length();
		int n = arr.length;
		
		for(int i=1;i<n;i++)
			if(arr[i].length()<min)
				min=arr[i].length();
		return min;
	}
	
	static String commonPrefix(String arr[],int n)
	{
		int min = getMinLength(arr);
		
		String result="";
		
		for(int i=0;i<min;i++)
		{
			char c = arr[0].charAt(i);
			
			for(int j=1;j<n;j++)
			{
				if(arr[j].charAt(i)!=c)
					return result;
			}
			result+=c;
		}
		return result;
	}

	public static void main(String[] args) {
		String arr[] = {"geeksforgeeks", "geeks","geek", "geezer"}; 
    int n = arr.length; 

    String ans = commonPrefix(arr, n); 

    if (ans.length() > 0)
        System.out.println("The longest common prefix is : "+ans);
    else
        System.out.printf("There is no common prefix");
	}
}
//Time Complexity : O(N M) where, N = Number of strings, M = Length of the largest string 
//Auxiliary Space : To store the longest prefix string we are allocating space which is O(M).