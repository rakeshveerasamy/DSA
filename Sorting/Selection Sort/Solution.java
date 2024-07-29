package com.sample;

import java.util.*;

public class practice {
   public static void main (String [] args) {
	   int [] arr =  new int [] {2,4,3,7,8,10,11,1};
	   Sorting sort = new Sorting(arr);
	   for(int value: sort.getResult()) {
		   System.out.print(value +" ");
	   }
	   
   }
    
   
}

class Sorting{
	private int [] arr ;
	private int len;
	
	Sorting(int [] arr){
		this.arr = arr;
		if(this.arr.length!=0) {
			this.len = arr.length;
			selectionSort();
		}
	}
		
	public void selectionSort() {
		for(int i=0;i<this.len-1;i++  ) {
			int minIndex = i;
			for(int j =i+1;j<this.len;j++) {
				if(this.arr[j]<this.arr[minIndex]) {
					minIndex = j;
				}
			}
			if(minIndex!=i) {
				swap(minIndex,i);
			}
		}
	}
	
	private void swap(int i , int j) {
		int temp = this.arr[i];
		this.arr[i] = this.arr[j];
		this.arr[j] = temp;
	}
	
	public int[] getResult() {
		return this.arr;
	}
}

