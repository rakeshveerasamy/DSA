//Insertion Sort Implementation
//Time Complexity ; O(n^2)

public class Solution {
	private void moveZeros(int [] arr ) {
		int temp;
		for (int  i = 1;i<arr.length;i++ ){
      temp  =  arr[i];
      for (int j  = i ;j>0 && (temp!=0 && arr[j-1]==0);j- - )
       arr[j] = arr[j-1];
      arr[j] = temp;			
		}
	}
	private void printArray(int [] arr ) {
		for(int i : arr ) {
			System.out.print(i+ “ “);
		}
	}
public static void main (String [] args) throws Exception {
Solution sol = new Solution ();
int [] arr =  new int [] {1,0 , 0, 3,12};
sol.printArray(arr);
sol.moveZeros(arr);
sol.printArray(arr);
}	
}
