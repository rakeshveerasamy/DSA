class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        KokoEatingBanana keb = new KokoEatingBanana(piles,h);
        return keb.minEatingSpeed();
    }
}

class KokoEatingBanana{
        private int [] piles;
        private int h;
    
        KokoEatingBanana(int [] piles, int h){
                this.piles = piles;
                this.h = h;
        }
        
        public int minEatingSpeed(){
                Arrays.sort(this.piles);
                int low  = 1;
                int high = this.piles[this.piles.length-1];
                while(low<=high){
                        int mid  = low +(high-low)/2;
                        
                        int eatablePiles = 0;
                        for(int pile:this.piles){
                                eatablePiles +=Math.ceil((double)pile/(double)mid);
                        }
                        if(eatablePiles<=this.h) high = mid-1;
                        else low = mid+1;
                }
            return low;
        }
        
}
