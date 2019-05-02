/*
Input : 1 2 3 4 5 6 7 
Output : 3 4 5 6 7 1 2 
*/
package com.array.array;

public class ArrayRotation {
	
	void leftRotate(int arr[],int len,int d) {
		
		for(int i=0;i<d;i++) {
			leftRotateUtil(arr,len);
		}
	}
	
	void leftRotateUtil(int arr[],int len) {
		int temp=arr[0];
		for(int i=1;i<len;i++) {
			arr[i-1]=arr[i];
		}
		arr[len-1]=temp;
	}
	
	void printArray(int arr[],int len) {
		for(int i=0;i<len;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		ArrayRotation rotate = new ArrayRotation(); 
    int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
    rotate.printArray(arr, arr.length);
    System.out.println();
    rotate.leftRotate(arr, arr.length, 2); 
    rotate.printArray(arr, arr.length); 
	}
}
//Time complexity : O(n)
//Auxiliary Space : O(1)
