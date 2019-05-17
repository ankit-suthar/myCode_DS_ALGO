// TREE 1 
    /* 
          26 
         /   \ 
        10     3 
       /    \     \ 
      4      6      3 
       \ 
        30 
    */ 

// TREE 2 
    /*  
       10 
     /    \ 
     4      6 
      \ 
      30  
    */

package com.binary.tree;

public class BTreeSubtreeOfAnotherBTree {
	
	Node root1;
	Node root2;
	
	class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data=data;
			left=right=null;
		}
	}
	
	public boolean isIdentical(Node n1,Node n2)
	{
		
		if(n1==null && n2==null)
			return true;
		
		if(n1==null || n2==null)
			return false;
		
		return (n1.data==n2.data) && isIdentical(n1.left,n2.left) && isIdentical(n1.right,n2.right);
	}
	
	public boolean checkSubtree(Node n1,Node n2)
	{
		if(n2==null)
			return true;
		
		if(n1==null)
			return false;
		
		if(isIdentical(n1,n2)) 
		{
			return true;
		}
		
		return checkSubtree(n1.left,n2) || checkSubtree(n1.right,n2);
	}
	
	public static void main(String[] args) {
		BTreeSubtreeOfAnotherBTree tree = new BTreeSubtreeOfAnotherBTree(); 
    
    
        
    tree.root1 = tree.new Node(26); 
    tree.root1.right = tree.new Node(3); 
    tree.root1.right.right = tree.new Node(3); 
    tree.root1.left = tree.new Node(10); 
    tree.root1.left.left = tree.new Node(4); 
    tree.root1.left.left.right = tree.new Node(30); 
    tree.root1.left.right = tree.new Node(6); 

    
        
    tree.root2 = tree.new Node(10); 
    tree.root2.right = tree.new Node(6); 
    tree.root2.left = tree.new Node(4); 
    tree.root2.left.right = tree.new Node(30); 

    if (tree.checkSubtree(tree.root1, tree.root2)) 
        System.out.println("Tree 2 is subtree of Tree 1 "); 
    else
        System.out.println("Tree 2 is not a subtree of Tree 1"); 
	}
}