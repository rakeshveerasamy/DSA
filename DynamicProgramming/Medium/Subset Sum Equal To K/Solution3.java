import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
		PartitionSum ps = new PartitionSum(arr,k);
		return ps.getResult();
    }
}

class PartitionSum {
	private int[] num;
	private int size;
	private int target;
	private boolean isPossible;

	PartitionSum(int [] num,int target){
    		this.num = num;
    		this.target = target;
    		this.isPossible = false;
    		
    		if(isValid()){
    			this.size =num.length;
    			isSubSetPossible();
    		}
    	}

	private boolean isValid() {
		return this.num != null && this.num.length != 0;
	}

	private void isSubSetPossible() {

		boolean [] prev= new boolean[this.target+1];

		prev[0] = true;
		
		if(this.num[0]<=target){
			prev[this.num[0]] = true;
		}

		for(int index =1;index<this.size;index++){
			boolean [] curr = new boolean [this.target+1];
			curr[0] = true;
			for(int target = 1;target<=this.target;target++){
					boolean notTake =  prev[target];
					boolean take = false;

					if(this.num[index]<=target){
						take =  prev[target -this.num[index]];
					}

					curr[target] = notTake||take;
			}
			prev = curr.clone();
		}
		this.isPossible = prev[this.target];
	}
	public boolean getResult() {
			return this.isPossible;
	}
}
