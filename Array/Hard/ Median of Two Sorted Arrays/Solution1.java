class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        if(nums1Length>nums2Length) return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int high = nums1Length;
        int left = (nums1Length+nums2Length+1)/2;
        while(low<=high){
            int nums1Mid = low +(high -low)/2;
            int nums2Mid = left - nums1Mid;

            int left1 = (nums1Mid-1>=0)?nums1[nums1Mid-1]:Integer.MIN_VALUE;
            int left2 = (nums2Mid-1>=0)?nums2[nums2Mid-1]:Integer.MIN_VALUE;

            int right1 = (nums1Mid<nums1Length)?nums1[nums1Mid]:Integer.MAX_VALUE;
            int right2 = (nums2Mid<nums2Length)?nums2[nums2Mid]:Integer.MAX_VALUE;

            if(left1<=right2 && left2<=right1) {
                if((nums1Length+nums2Length)%2 == 0){
                    return (double) ((Math.max(left1,left2)+Math.min(right1,right2))/2.0);
                }
                return (double)Math.max(left1,left2);
            }

            else if (right2<left1){
                high = nums1Mid-1;
            }
            else low = nums1Mid+1;
        }
        return 0;
    }
}
