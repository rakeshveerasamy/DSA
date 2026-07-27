import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..

		int prev2 = 0;
		int prev = 0;
		int curr = 0;

		for(int i=1;i<n;i++){
			int oneStep  = prev + Math.abs(heights[i] - heights[i-1]);

			int twoStep = Integer.MAX_VALUE;

			if(i>1){
				twoStep = prev2 + Math.abs(heights[i] - heights[i-2]);

			}

			curr  = Math.min(oneStep, twoStep);

			prev2 = prev;
			prev =  curr;
		}

		return prev;
    }

}
