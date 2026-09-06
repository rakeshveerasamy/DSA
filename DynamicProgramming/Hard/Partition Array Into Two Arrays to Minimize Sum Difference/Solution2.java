class Solution {
    public int minimumDifference(int[] nums) {

        int n = nums.length/2;

        int total = 0;
        for(int num:nums){
            total+=num;
        }

        List<Integer>[] left = new ArrayList[n+1];
        List<Integer>[] right = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        generate(nums,0,n,0,0,left);
        generate(nums,n,nums.length,0,0,right);

        for(int i=0;i<=n;i++){
            right[i].sort(Integer::compareTo);
        }

        int answer = Integer.MAX_VALUE;

        for(int count =0;count<=n;count++){
            List<Integer> leftSums = left[count];
            List<Integer> rightSums = right[n-count];

            for(int leftSum: leftSums){

                double target = (total/2.0) - leftSum;

                int index = lowerBound(rightSums, target);

                if(index<rightSums.size()){

                    int sum = leftSum+rightSums.get(index);

                    answer = Math.min(answer, Math.abs(total - 2*sum));
                    
                }

                if(index>0){
                    int sum = leftSum+rightSums.get(index-1);
                    answer = Math.min(answer, Math.abs(total - 2*sum));
                }
            }
        }

        return answer;
        
    }

    public void generate(int[] nums , int start, int end, int sum , int count, List<Integer>[] result){
        if(start == end){
            result[count].add(sum);
            return;
        }

        generate(nums , start+1, end, sum,count,result);
        generate(nums , start+1, end , sum+nums[start], count+1, result);
    }

    private int lowerBound(List<Integer> list, double target){
        int low = 0;
        int high = list.size();

        while(low<high){
            int mid = low + (high - low)/2;

            if(list.get(mid)<target){
                low = mid+1;
            }

            else{
                high = mid;
            }
        }
        return low;
    }
}
