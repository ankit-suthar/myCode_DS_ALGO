/*
A Trie is used to store dictionary words so that they can be searched efficiently and 
prefix search can be done. The task is to write a function to count the number of words.

Example :

Input :     root
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
Output : 8
Explanation : Words formed in the Trie : 
"the", "a", "there", "answer", "any", "by", 
"bye", "their".
*/

public class CountingNumberOfWords {

	int ALPHABET_SIZE = 26;
	TrieNode root=new TrieNode();
	
	class TrieNode{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;
		
		TrieNode() {
			for(int i=0;i<ALPHABET_SIZE;i++)
				children[i]=null;
			isEndOfWord=false;
		}
	}
	
	void insert(String key) {
		TrieNode tn = root;
		
		for(int i=0;i<key.length();i++) {
			int index = key.charAt(i)-'a';
			
			if(tn.children[index]==null)
				tn.children[index]=new TrieNode();
			tn=tn.children[index];			
		}
		tn.isEndOfWord=true;
	}
	
	int countWord(TrieNode node) {
		
		int result=0;
		
		if(node.isEndOfWord)
			result++;
		
		for(int i=0;i<ALPHABET_SIZE;i++) {
			if(node.children[i]!=null)
				result+=countWord(node.children[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		CountingNumberOfWords c = new CountingNumberOfWords();
		String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their", "apple", "bbye"};
		
		for(int i=0;i<keys.length;i++) {
			c.insert(keys[i]);
		}
		
		int cValue = c.countWord(c.root);
		System.out.println(cValue);
	}
}
