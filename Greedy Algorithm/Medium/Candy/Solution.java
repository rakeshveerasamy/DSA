class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int left[] = new int[size];
        int count = 0;

        Arrays.fill(left,1);

        for(int i=1;i<size;i++){
            if(ratings[i]>ratings[i-1] && left[i]<=left[i-1]){
                left[i] = left[i-1]+1;
            }
        }

        for(int i=size-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && left[i]<=left[i+1]){
                left[i] = left[i+1]+1;
            }
        }
        for(int value:left){
            System.out.print(value+" ");
            count+=value;
        }
        return count;
    }
}
