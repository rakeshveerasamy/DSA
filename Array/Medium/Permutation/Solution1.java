import java.util.stream.IntStream;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        generatePermuation(nums,res);
        return res;
    }
    private void generatePermuation(int [] nums ,List<List<Integer>> res ) {
		generatePermutationHelper(nums, 0 , res);
	}
	private void generatePermutationHelper(int [] nums , int index , List<List<Integer>> res) {
		if(index == nums.length) {
			List<Integer> arr = IntStream.of(nums).mapToObj(Integer::valueOf).collect(Collectors.toList());
            res.add(arr);
			return;
		}
		for(int i = index;i<nums.length;i++){
			swap(nums,index,i);
			generatePermutationHelper(nums,index+1,res);
			swap(nums,index,i);
		}
		
	}
	private void swap(int [] nums , int i,int j){
		int temp =  nums[i];
		nums[i] = nums[j];
		nums[j] =  temp;
	}

}
