class Solution {
    public int minAddToMakeValid(String s) {
        ParenthesisValidator pv = new ParenthesisValidator(s);
        return pv.minAddToMakeValid();
    }
}

class ParenthesisValidator{
    private String s;
    ParenthesisValidator(String s){
        this.s =s;
    }
    public int minAddToMakeValid(){
        Stack<Character> validator =new Stack<>();
        int neededParenthesis = 0;
        for(char ch : this.s.toCharArray()){
            switch(ch){
            case '(':
                      validator.push(ch);
                      break;
            case ')':
                    if(validator.isEmpty() || validator.peek()!='(') neededParenthesis++;
                    else validator.pop();
                    break;
            }
        }
        neededParenthesis+=validator.size();
        return neededParenthesis;
    }
}
