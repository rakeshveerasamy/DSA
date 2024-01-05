
//Below solution will print star index, end index and also suubstring 

public class Main
{
    private int lengthOfLongestSubstring(String word) {
        if(word == null || word.length() == 0 ){
            return 0;
        }
        HashMap<Character , Integer> charIndex =  new HashMap<>();
        int start = 0;
        int startIndex = start;
        int endIndex = start;
        int maxLength = 0;
        for(int end = 0;end<word.length();end++) {
            if(charIndex.containsKey(word.charAt(end)) && charIndex.get(word.charAt(end))>=start) {
                start = charIndex.get(word.charAt(end)) + 1;
            }
            charIndex.put(word.charAt(end),end);
            if(maxLength<(end-start+1)){
                maxLength = end - start+1;
                startIndex  =  start;
                endIndex  =  end;
            }
        }
        System.out.println(startIndex+ "    "+endIndex);
        System.out.println(word.substring(startIndex,endIndex+1));
        return maxLength;
    }
    public static void main (String [] args) throws Exception {
        Main sol =  new Main();
        String str = "rakesh";
        System.out.println(sol.lengthOfLongestSubstring(str));
    }





}
