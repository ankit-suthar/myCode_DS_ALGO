/*
The following picture explains construction of trie using keys given in the example below,

                       root
                    /   \    \
                    t   a     b
                    |   |     |
                    h   n     y
                    |   |  \  |
                    e   s  y  e
                 /  |   |
                 i  r   w
                 |  |   |
                 r  e   e
                        |
                        r
*/

public class InsertSearch {
	
	static final int ALPHABET_SIZE = 26;

	static class TrieNode{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		
		boolean isEndOfWord;
		
		TrieNode() {
			isEndOfWord=false;
			for(int i=0;i<ALPHABET_SIZE;i++)
				children[i] = null; 
		}
	}
	
	static TrieNode root;
	
	static void insert(String key) {
		
		TrieNode temp = root;
		
		for(int i=0;i<key.length();i++) {
			int index = key.charAt(i)-'a';
			
			if(temp.children[index]==null)
				temp.children[index] = new TrieNode();
			temp=temp.children[index];
		}
		temp.isEndOfWord=true;
	}
	
	static boolean search(String key) {
		TrieNode temp = root;
		
		for(int i=0;i<key.length();i++) {
			int index = key.charAt(i)-'a';
			
			if(temp.children[index]==null)
				return false;
			temp=temp.children[index];
		}
		return (temp!=null && temp.isEndOfWord);
	}
	
	public static void main(String[] args) {
		String keys[] = {"the", "a", "there", "answer", "any", 
        "by", "bye", "their"};
		
		String output[] = {"Not present in trie", "Present in trie"};
		
		root = new TrieNode();
		
		int i;
		for(i=0;i<keys.length;i++)
			insert(keys[i]);
		
		if(search("the") == true) 
      System.out.println("the --- " + output[1]); 
		else System.out.println("the --- " + output[0]); 
    
		if(search("these") == true) 
      System.out.println("these --- " + output[1]); 
		else System.out.println("these --- " + output[0]); 
    
		if(search("their") == true) 
      System.out.println("their --- " + output[1]); 
		else System.out.println("their --- " + output[0]); 
    
		if(search("thaw") == true) 
      System.out.println("thaw --- " + output[1]); 
		else System.out.println("thaw --- " + output[0]);
	}
}
