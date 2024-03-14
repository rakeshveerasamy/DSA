class Solution {
    public int minAddToMakeValid(String s) {
        ParenthesisValidator pv = new ParenthesisValidator(s);
        return pv.getCount();
    }
}
class ParenthesisValidator{
    private String s;
    ParenthesisValidator(String s){
        this.s = s;
    }
    public int getCount(){
       int open = 0;
        int needed = 0;
        for(char ch : this.s.toCharArray()){
            if(ch == '('){
                open++;
            }
            else {
                if(open>0) open--;
                else {
                    needed++;
                }
            }
        }
        return needed+open;
    }
}
