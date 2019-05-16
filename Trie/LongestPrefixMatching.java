/*
Let the dictionary contains the following words:
{are, area, base, cat, cater, children, basement}

Below are some input/output examples:
--------------------------------------
Input String            Output
--------------------------------------
caterer                 cater
basemexy                base
child                   < Empty >
*/

import java.util.HashMap;

class TrieNode{
	private char value;
	private HashMap<Character,TrieNode> children;
	private boolean isEndOfWord;
	
	public TrieNode(char ch){
		value=ch;
		children=new HashMap<>();
		isEndOfWord=false;
	}
	
	public HashMap<Character,TrieNode> getChildren(){ return children; }
	public char getValue() { return value; }
	public void setIsEnd(boolean ch) { isEndOfWord=ch; }
	public boolean isEnd() { return isEndOfWord; }
}

public class LongestPrefixMatching {
	private TrieNode root;
	
	LongestPrefixMatching(){
		root = new TrieNode((char)0);
	}
	
   void insert(String key) {
		TrieNode tn = root;
  	 
		for(int i=0;i<key.length();i++) {
			HashMap<Character,TrieNode> c = tn.getChildren();
			char ch = key.charAt(i);
			
			if(c.containsKey(ch)) {
				tn=c.get(ch);
			}
			else {
				TrieNode temp = new TrieNode(ch);
				c.put(ch, temp);
				tn=temp;
			}	
		}
		tn.setIsEnd(true);
	}
   
  public String getMatchingPrefix(String input) {
  	String result="";
  	
  	TrieNode tn = root;
  	int prevNode=0;
  	
  	for(int i=0;i<input.length();i++) {
  		
  		char ch = input.charAt(i);
  		
  		HashMap<Character,TrieNode> child = tn.getChildren();
  		
  		if(child.containsKey(ch)) {
  			result+=ch;
  			tn=child.get(ch);
  			
  			if(tn.isEnd())
  				prevNode=i+1;
  		}
  		else break;
  	}
  	
  	if(!tn.isEnd())
  		return result.substring(0,prevNode);
  	else 
  		return result;
  }
	
	public static void main(String[] args) {
		String keys[] = {"are", "area", "base", "cat", "cater", "basement"}; 
		
		LongestPrefixMatching l = new LongestPrefixMatching();
		
		for(int i=0;i<keys.length;i++) {
			l.insert(keys[i]);
		}
		
		String input = "caterer"; 
    System.out.print(input + ":   "); 
    System.out.println(l.getMatchingPrefix(input));               

    input = "basement"; 
    System.out.print(input + ":   "); 
    System.out.println(l.getMatchingPrefix(input));                       

    input = "are"; 
    System.out.print(input + ":   "); 
    System.out.println(l.getMatchingPrefix(input));               

    input = "arex"; 
    System.out.print(input + ":   "); 
    System.out.println(l.getMatchingPrefix(input));               

    input = "basemexz"; 
    System.out.print(input + ":   "); 
    System.out.println(l.getMatchingPrefix(input));                       

    input = "xyz"; 
    System.out.print(input + ":   "); 
    System.out.println(l.getMatchingPrefix(input)); 	
	}
}
