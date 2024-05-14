//$Id$
package practice.test.pkg;

import java.util.*;
import java.util.regex.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        System.out.println("The Min Heap is ");
        minHeap.print();
        System.out.println("The Min val is " + minHeap.removeMin());
        minHeap.print();

        System.out.println("The Min val is " + minHeap.removeMin());
        minHeap.print();



	}

}

class MinHeap{
	private int size;
	private int capacity;
	private int [] heap;
	
	MinHeap(int capacity){
		this.capacity = capacity;
		this.size =0;
		this.heap = new int[this.capacity+1];
	}
	public boolean isLeaf(int i) {
		return i>=this.size/2 && i<=this.size;
	}
	public int left(int i) {
		return i*2;
	}
	public int right(int i) {
		return 2*i+1;
	}
	public int parent(int i) {
		return i/2;
	}
	private void swap(int i, int j) {
		int temp = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = temp;
	}
	public void insert(int i) {
		if(this.size>=this.capacity) {
			System.out.println("Heap is full");
			return ;
		}
		this.size++;
		this.heap[size] = i;
		int current = this.size;
		
		while(this.heap[current]< heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public int removeMin() {
		int min =this.heap[1];
		this.heap[1] = this.heap[this.size];
		heapify(1);
		return min;
	}
	public void print() {
        for (int i = 1; i <= this.size / 2; i++) {
            System.out.print(" PARENT : " + this.heap[i] + " LEFT CHILD : " + this.heap[2 * i]
                    + " RIGHT CHILD :" + this.heap[2 * i + 1]);
            System.out.println();
        }
    }
	
	public void heapify(int i)
	{
		if(!isLeaf(i)) {
			int smallest = i;
			int left = left(i);
			int right =right(i);
			
			if(left<=this.size && this.heap[left]<this.heap[smallest]) {
				smallest = left;
			}
			if(right<=this.size && this.heap[right]<this.heap[smallest]) {
				smallest = right;
			}
			if(smallest!=i) {
				swap(i,smallest);
				heapify(smallest);
			}
		}
	}
}
