class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int size = bloomDay.length;
        
        if(((long)m*(long)k)>(long)size){
            return -1;
        }
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high =  Arrays.stream(bloomDay).max().getAsInt();
        while(low<high){
            int mid = low+(high-low)/2;
            if(canForm(bloomDay,mid,m,k)){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return low;
    }
    public boolean canForm(int[]bloomDay, int day,int m, int k){
        int adjacent = 0;
        int bouquetCount = 0;
        for(int bloom : bloomDay){
            if(bloom>day){
                bouquetCount+=(adjacent/k);
                adjacent = 0;
            }else{
                adjacent++;
            }
        }
        bouquetCount+=(adjacent/k);
        return bouquetCount>=m;

    }
}
