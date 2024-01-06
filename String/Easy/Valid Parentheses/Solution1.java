//Time complexity - O(n)
//Space Complexity - O(n)


class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1 || (s.length()%2)!=0){
            return false;
        }
        Stack <Character> stk = new Stack<>();
        for(Character c : s.toCharArray()){
            switch(c){
                case ')':
                    if(stk.isEmpty() || stk.peek()!='('){
                        return false;
                    }
                    stk.pop();
                    break;
                case '}':
                    if(stk.isEmpty() || stk.peek()!='{'){
                        return false;
                    }
                    stk.pop();
                    break;
                case ']':
                    if(stk.isEmpty() || stk.peek()!='['){
                        return false;
                    }
                    stk.pop();
                    break;
                default:
                    stk.push(c);
                    break;
            }

        }
        if(!stk.isEmpty()) return false;
        return true;
        
    }
}
