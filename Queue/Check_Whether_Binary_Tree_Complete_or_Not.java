/*
The following trees are examples of Complete Binary Trees
    1
  /   \
 2     3
  
       1
    /    \
   2       3
  /
 4
 
       1
    /    \
   2      3
  /  \    /
 4    5  6
 
The following trees are examples of Non-Complete Binary Trees

    1
      \
       3
  
       1
    /    \
   2       3
    \     /  \   
     4   5    6

       1
    /    \
   2      3
         /  \
        4    5
*/

import java.util.LinkedList;
import java.util.Queue;

public class Check_Whether_Binary_Tree_Complete_or_Not {
	
	Node root;
	
	class Node
	{
		int data;   
		Node left,right;
		
		Node(int d)
		{
			data=d;
			left=right=null;
		}
	}
	
	
	public boolean isCompleteBT(Node node)
	{
		if(node==null)
			return true;
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(node);
		boolean foundFirstNonFull=false;
		
		while(!queue.isEmpty())
		{
			node=queue.poll();
			
			if(foundFirstNonFull)
			{
				if(node.left!=null || node.right!=null)
				{
					return false;
				}
				continue;
			}
			
			if(node.left!=null && node.right!=null)
			{
				queue.offer(node.left);
				queue.offer(node.right);
			}
			else if(node.left!=null)
			{
				queue.offer(node.left);
				foundFirstNonFull=true;
			}
			else if(node.right!=null)
			{
				return false;
			}
			else
				foundFirstNonFull=true;	
		}
		return true;
	}

	public static void main(String[] args) {
		Check_Whether_Binary_Tree_Complete_or_Not tree=new Check_Whether_Binary_Tree_Complete_or_Not();
		
		tree.root=tree.new Node(1);
		tree.root.left=tree.new Node(2);
		tree.root.right=tree.new Node(3);
		tree.root.left.left=tree.new Node(4);
		tree.root.left.right=tree.new Node(5);
		tree.root.right.right=tree.new Node(6);
 // tree.root.right.left=tree.new Node(6);   //<-- this makes complete binary tree
		
		
		if(tree.isCompleteBT(tree.root)){
			System.out.println("This is complete binary tree");
		}
		else
		{
			System.out.println("This is NOT complete binary tree");
		}
	}
}
// Time Complexity: O(n) where n is the number of nodes in given Binary Tree
// Auxiliary Space: O(n) for queue.
