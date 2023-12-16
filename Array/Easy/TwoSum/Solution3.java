//Optimise two pointer approach -  Array sorted
//Time complexity - O(n/2)

public class Main {
    private int [] findTwoSum(int [] arr, int target ) {
        int left  = 0;
        int right  =  arr.length-1;
        while(left<right) {
            if(arr[left]+arr[right] ==  target) return new int []{left,right};
            else if ((arr[left]+arr[right])<target) left++;
			else right--;
        }
        throw new IllegalArgumentException("Invalid Array");

    }
    private void printArray(int [] arr) {
        for(int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static void main (String [] args) throws Exception {
        Main ts =  new Main();
        int [] arr =  new int []{3,7,11,15};
        int target = 14;
        int [] res  =  ts.findTwoSum(arr,target);
        ts.printArray(res);
    }

}
