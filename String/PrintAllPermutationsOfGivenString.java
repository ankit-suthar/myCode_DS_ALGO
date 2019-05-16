/*
A string of length n has n! permutation.

The permutations of string ABC:
ABC ACB BAC BCA CBA CAB
*/
package com.array.array;

public class PrintAllPermutationsOfGivenString {
	
	void permute(String str,int l,int h)
	{
		if(l==h)
			System.out.println(str);
		else
			for(int i=l;i<=h;i++)
			{
				str = swap(str,l,i);
				permute(str,l+1,h);
				str = swap(str,l,i);
			}	
	}
	
	public String swap(String a, int i, int j) 
  	{ 
		char ch[] = a.toCharArray();
		
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		
		return String.valueOf(ch);
  	}

	public static void main(String[] args) {
		PrintAllPermutationsOfGivenString permutation = new PrintAllPermutationsOfGivenString();
		String str = "1234";//"ABC"; 
    		int n = str.length(); 
    		permutation.permute(str, 0, n - 1); 
	}
}
