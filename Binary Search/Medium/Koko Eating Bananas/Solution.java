class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =  1;
        int high = Arrays.stream(piles).max().getAsInt();
        int hour = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if(canEat(piles,mid,h)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean canEat(int [] piles,int speed,int h){
        int hours = 0;
        for(int pile:piles){
            hours+=(pile+speed-1)/speed; // ceiling division
        }
        return hours<=h;
    }
}
