//Time Complexity = O(sqrt(n))
//space complexity = O(sqrt(n))

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParanthesis(list,"",0,0,n);
        return list;
    }
    public void generateParanthesis(List<String> list, String str, int open , int close, int limit){
        if(str.length() == (limit*2)){
            list.add(str);
            return;
        }
        if(open<limit){
            generateParanthesis(list,str+"(",open+1,close,limit);
        }
        if(close<open){
            generateParanthesis(list,str+")",open,close+1,limit);
        }
    }
}
