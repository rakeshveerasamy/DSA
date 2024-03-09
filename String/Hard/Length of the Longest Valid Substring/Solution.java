class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbidenSet = new HashSet<String>(forbidden);
        int i = 0;
        int j = 0;
        int max = 0;
        int size = word.length();
        int end = size -1;
        for(i = size-1;i>=0;i--){
            for(j = i;j<=end && j<i+10 ; j++ ){
                String sub = word.substring(i,j+1);
                if(forbidenSet.contains(sub)){
                    end = j-1;
                    break;
                }
            }
            max = Math.max(max,end-i+1);
        }
        return max;
    }
}
