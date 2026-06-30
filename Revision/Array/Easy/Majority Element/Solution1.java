class Solution {
    public int majorityElement(int[] nums) {
        MajorityElement me = new MajorityElement(nums);
        return me.findMax();
    }
}

class MajorityElement{
    private int [] nums;

    MajorityElement(int [] nums){
        this.nums= nums;
    }

    public int findMax(){

            if(!isValid()){
                return -1;
            }

            int candidate  = 0;
            int count =0;

            for(int num: this.nums){
                if(count == 0){
                    candidate = num;
                }
                if(num == candidate) count++;
                else count--;
            }

            return this.isValidCandidate(candidate)? candidate: -1;
    }

    private boolean isValidCandidate(int candidate){
        int count = 0;
       
        for(int num: this.nums){
            if(num == candidate) count++;
        }

        return (count> (this.nums.length/2));
    }

    private boolean isValid(){
        return this.nums!=null && this.nums.length>0;
    }
}
