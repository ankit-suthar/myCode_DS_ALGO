public class ValidPalindrome {
	
	public static boolean checkPalindrome(String str)
	{
		
		String ans="";
		
		str = str.toLowerCase();
		
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)>=97 && str.charAt(i)<122)
				ans+=str.charAt(i);
		
		int l = 0;
		int h = ans.length()-1;
		
		while(l<h)
		{
			if(ans.charAt(l)==ans.charAt(h))
			{
				l++;
				h--;				
			}
			else if(ans.charAt(l)!=ans.charAt(h))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		//String str="A man, a plan, a canal:Panama"; //Palindrome
		String str = "race a car";  //Not palindrome
		
		if(checkPalindrome(str))
			System.out.println("Palindrome");
		else
			System.out.println("Not palindrome");
	}
}
