package com.tejas.network;

/*
Given String S made of lowercase English alphabets.
Find the character having the kth largest frequency.
It is more than one character that meets the condition, print the smallest one.
If there is no character that meets the condition print -1.

I/P:
String s = "aabcd" K=3 (3rd largest)
O/P: -1

I/P:
String s = "aabcd" K=2 (2nd largest)
O/P: b
*/
public class K_Frequency {

	static int MAX=26;
	
	static String get_K_frequency(String str,int K)
	{
		int ch[] = new int[MAX];
		int t=0;
		int max=0;
		
		
		for(int i=0;i<str.length();i++)
		{
			t = str.charAt(i)-'a';
			ch[t]++;
			
			if(max<ch[t])
				max=ch[t];
		}
		
		int val = max-(K-1);
		
		if(val<=0)
			return "-1";
		
		int update=0;
		int temp=0;
		
		for(int i=0;i<MAX;i++)
			if(ch[i]>0 && ch[i]<=val && update<ch[i])
			{
				update = ch[i];
				temp=i;
			}
		
		if(update!=0 && temp!=0)
		{
			char c = (char)('a' + temp);
			return Character.toString(c);
		}
		
		return "-1";
	}
	
	public static void main(String[] args) 
	{	
		String str="aaabcacddd";
		int K=5;
		
		System.out.println(get_K_frequency(str.toLowerCase(),K));
	}
}