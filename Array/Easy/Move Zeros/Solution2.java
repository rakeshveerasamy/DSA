public class Solution {
	private void moveZeros(int [] arr ) {
		int nonZeroIndex = 0;
		int i;
		for( i = 0 ;i<arr.length;i++) {
			if(arr[i]!=0) {
			   arr[nonZeroIndex] = arr[i];
			   nonZeroIndex++;
			}
		}
		for(i = nonZeroIndex;i<arr.length;i++) {
			arr[i] = 0;
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
