// Time Complexity = O(n^3)

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        long sum =0;
        
        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){

            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1; j<nums.length-2;j++){

                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                left = j+1;
                right = nums.length-1;

                while(left<right) {
                    sum =(long)( nums[i] +nums[j] +nums[left] + nums[right]);

                    if(sum ==target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while(left<right && nums[left] == nums[left-1]){
                            left++;
                        }

                        while(left<right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }

                    else if(sum>target){
                         right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }

        return result;
        
    }
}
