/*
Given a string s and two words w1 and w2 that are present in S. The task is to find the minimum distance 
between w1 and w2. Here distance is the number of steps or words between the first and the second word.

Examples:

Input : s = “geeks for geeks contribute practice”, w1 = “geeks”, w2 = “practice”
Output : 1
There is only one word between closest occurrences of w1 and w2.

Input : s = “the quick the brown quick brown the frog”, w1 = “quick”, w2 = “frog”
Output : 2
*/

package com.array.array;

public class MinDistanceBtWordsOfString {
	
	public static int findDistance(String s[]) {
		int diff = Integer.MAX_VALUE;
		
		int w1 = Integer.MAX_VALUE;
		int w2 = Integer.MAX_VALUE;
		
		String s1="quick";//"geeks";//"Amazon";
		String s2="frog";//"practice";//"The";
		
		for(int i=0;i<s.length;i++) {
		
			if(s[i].equalsIgnoreCase(s1)) {
				w1=i;
				if(w2!=Integer.MAX_VALUE)
					if(Math.abs(w1-w2)<diff)
						diff=Math.abs(w1-w2);
			}
			
			if(s[i].equalsIgnoreCase(s2)) {
				w2=i;
				if(w1!=Integer.MAX_VALUE)
					if(Math.abs(w1-w2)<diff)
						diff=Math.abs(w1-w2);
			}
			
		}
		return diff-1;
	}

	public static void main(String[] args) {
		//String str = "Amazon is the best company to work for. The amazon is a beautiful forest.";
		
		//String str = "geeks for geeks contribute practice";
		
		String str = "the quick the brown quick brown the frog";
		
		String s[] = str.split("\\s+");
		
		System.out.println(findDistance(s));
	}
}