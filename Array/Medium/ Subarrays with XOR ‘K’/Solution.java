import java.util.*;
public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here

        int count = 0;
        Map<Integer,Integer> xorCounter = new HashMap<>();
        int xor = 0;

        for(int num: a){

                xor^=num;

                if(xor == b){
                    count++;
                }
                int complement = xor^b;
                count+=xorCounter.getOrDefault(complement,0);
                xorCounter.put(xor,xorCounter.getOrDefault(xor,0)+1);
        }
        return count;
    }
}
