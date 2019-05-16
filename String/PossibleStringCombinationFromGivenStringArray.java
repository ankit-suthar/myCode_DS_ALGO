public class PossibleStringCombinationFromGivenStringArray {

	static void recursiveFunction(String str[],int index,String ans)
	{
			if(index==str.length)
			{
				System.out.println(ans);
				return;
			}
			
			for(int k=0;k<str[index].length();k++)
			{
				ans+=str[index].charAt(k);
				
				recursiveFunction(str,index+1,ans);
				ans = ans.substring(0, index);
			}
	}
	
	public static void main(String[] args) {
		String str[] = {"abc","def","ghi"};
		
		recursiveFunction(str,0,"");
	}
}

//Output:
/*
adg
adh
adi
aeg
aeh
aei
afg
afh
afi
bdg
bdh
bdi
beg
beh
bei
bfg
bfh
bfi
cdg
cdh
cdi
ceg
ceh
cei
cfg
cfh
cfi
*/
