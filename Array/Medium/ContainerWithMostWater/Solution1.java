class Solution {
    public int maxArea(int[] height) {
        ContainerWithWater cw =  new ContainerWithWater(height);
        return cw.maxArea();
    }
}

class ContainerWithWater{
        private final int [] height;
        ContainerWithWater(int[] height){
            this.height = height;
        }
        public int maxArea(){
            int sum = 0;
            int maxArea = 0;
            int left=0;
            int right =this.height.length-1;
            while(left<right){
                    if(this.height[left]<=this.height[right]){
                            sum = height[left]*(right-left);
                            left++;
                    }
                    else{
                            sum =height[right]*(right-left);
                            right--;
                    }
                    maxArea = Math.max(maxArea,sum);
            }
            return maxArea;
            
        }
}
