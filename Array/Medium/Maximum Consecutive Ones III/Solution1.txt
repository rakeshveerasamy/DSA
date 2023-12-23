public static MaxConsecutiveOne {
	private int findMaxOnes (int [] arr) {
		int zeroCount = 0 ;
		int left  = 0;
		int sum = 0;
		for(int right  = 0; right<arr.length;right++) {
			if(arr[right] == 0) zeroCount++;
			while(zeroCount>1) {
				if(arr[left] == 0) zeroCount - -;
			 left++;
			}
			sum   =  Math.max(sum , right-left+1);
		}
		return sum;
	}	
public static void main (String [] args ) throws Exception {
	MaxConsecutiveOne mc = new MaxConsecutiveOne();
	int [] arr = new int [] {1,1,0,1,1,1,1};
	System.out.println(mc.findMaxOnes(arr));
}	
}
