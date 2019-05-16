/*
Design a data structure that supports following operations in Θ(1) time.

insert(x): Inserts an item x to the data structure if not already present.

delete(x): Removes an item x from the data structure if present.

search(x): Searches an item x in the data structure.

getRandom(): Returns a random element from current set of elements
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class DS_Insert_Delete_Search_Random_ConstantTime {
	
	HashMap<Integer,Integer> hs;
	ArrayList<Integer> al;
	
	public DS_Insert_Delete_Search_Random_ConstantTime()
	{
		hs = new HashMap<Integer,Integer>();
		al = new ArrayList<Integer>();
	}
	
	public void insert(int data)
	{
		if(!hs.containsKey(data))
		{
			hs.put(data,al.size());
			al.add(data);
		}
	}
	
	public void delete(int data)
	{
		if(hs.containsKey(data))
		{
			int index = hs.get(data);
			int temp = al.size()-1;
			
			Collections.swap(al, index, temp);
			al.remove(temp);
			
			hs.remove(data);
			hs.put(al.get(index), index);
		}
	}

	public int search(int data)
	{
		return hs.get(data);
	}
	
	public int getRandom()
	{
		// get a random index from 0 to size - 1
		Random random = new Random();
		int index = random.nextInt(al.size());
		return al.get(index);
	}
	public static void main(String[] args) {
		DS_Insert_Delete_Search_Random_ConstantTime ref = new DS_Insert_Delete_Search_Random_ConstantTime(); 
    ref.insert(10); 
    ref.insert(20); 
    ref.insert(30); 
    ref.insert(40); 
    System.out.println(ref.search(30)); 
    ref.delete(20); 
    ref.insert(50); 
    System.out.println(ref.search(50)); 
    System.out.println(ref.getRandom()); 
	}
}
