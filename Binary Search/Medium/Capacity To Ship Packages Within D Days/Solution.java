class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        while(low<high){
            int mid = low+(high-low)/2;
            if(canLoad(weights,mid , days)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean canLoad(int[] weights, int maxAllowed,int days){
        int count = 0;
        int sum = 0;
        for(int num:weights)
        {
            sum+=num;
            if(sum>maxAllowed){
                sum= num;
                count++;
            }
        }
        if(sum!=0){
            count++;
        }
        return count<=days;
    }
}
