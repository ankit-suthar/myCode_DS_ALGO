/*
Given a set of strings, find the longest common prefix.

Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"
*/
package com.array.array;

public class LongestCommonPrefixUsingWordByWordMatching {
	
	static String commonPrefix(String arr[],int n)
	{
		String temp = arr[0];
		int j=0,k=0;
		
		for(int i=1;i<n;i++)
		{
			String newString  = arr[i];
			String ans = "";
			j=0;k=0;
			
			while(j<temp.length() && k<newString.length())
			{
				if(temp.charAt(j)!=newString.charAt(k))
					break;
				
				ans += temp.charAt(j);
				j++; k++;
			}
			temp=ans;
		}
		return temp;
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