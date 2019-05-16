/*
Given a Binary tree and a key in the binary tree, find the node right to the given key. 
If there is no node on right side, then return NULL. 
Expected time complexity is O(n) where n is the number of nodes in the given binary tree.

For example, consider the following Binary Tree. Output for 2 is 6, output for 4 is 5. Output for 10, 6 and 5 is NULL.
                  10
               /      \
             2         6
           /   \         \ 
     		 8      4          5
*/

import java.util.ArrayList;
import java.util.HashMap;

public class FindNextRightNodeOfGivenKey {
	Node root;
	
	class Node 
	{ 
		int data; 
		Node left, right; 

		Node(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
	}
	
	int height(Node n)
	{
		if(n==null)
			return 0;
		
		return Math.max(height(n.left), height(n.right))+1;
	}
	
	void findRightNode(Node n,int d)
	{
		int h = height(n);
		HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<Integer> al;
		
		for(int i=0;i<h;i++)
		{
		  al = new ArrayList<Integer>();
			
		  levelOrder(n,i+1,al);
		  
			hm.put(i+1, al);
		}
		
		for(int i=0;i<h;i++)
		{
			al = hm.get(i+1);
			
			for(int j=0;j<al.size();j++)
				if(al.get(j)==d)
					if(j+1<al.size())
					{
						System.out.println("Next Right of "+d+" is "+al.get(j+1));
						return;
					}
		}
		System.out.println("No next right node found for "+d);
	}
	
	
	void levelOrder(Node n,int level,ArrayList<Integer> al)
	{
		if(n==null)
			return;
		
		if(level==1)
			al.add(n.data);
		else
		{
			levelOrder(n.left,level-1,al);
			levelOrder(n.right,level-1,al);
		}
	}
	
	public static void main(String[] args) {
		FindNextRightNodeOfGivenKey tree = new FindNextRightNodeOfGivenKey(); 
		tree.root = tree.new Node(10); 
		tree.root.left = tree.new Node(2); 
		tree.root.right = tree.new Node(6);
		tree.root.right.right = tree.new Node(5); 
		tree.root.left.left = tree.new Node(8); 
		tree.root.left.right = tree.new Node(4);
		
		tree.findRightNode(tree.root,10);
		tree.findRightNode(tree.root,2);
		tree.findRightNode(tree.root,6);
		tree.findRightNode(tree.root,5);
		tree.findRightNode(tree.root,8);
		tree.findRightNode(tree.root,4);		
	}
}
