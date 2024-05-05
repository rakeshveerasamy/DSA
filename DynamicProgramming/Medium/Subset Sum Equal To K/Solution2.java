import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int size =arr.length;
        return findSubSet(size-1,k,arr);
    }
    private static  boolean findSubSet(int index, int k , int arr[]){

            if(index<0) return false;
            if(k == 0){
                return true;
            }
            if(index == 0 && arr[0] == k){
                return true;
            }
            boolean notTaken =  findSubSet(index-1, k, arr);
            boolean taken =false;
            if(k>=arr[index]){
                taken = findSubSet(index-1, k-arr[index],arr);
            }
            return taken || notTaken;
    }
}
