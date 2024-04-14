import java.util.*;
public class Solution {
    public static String infixToPostfix(String exp) {
        // Write your code here
        InfixToPostFix iop = new InfixToPostFix(exp);
        return iop.convertor();
    }
}
class InfixToPostFix{
	private String expression;	

	InfixToPostFix(String expression){
		this.expression = expression;
	}	
		
	private boolean isOperator(char ch){
		return ch =='+' || ch =='-' || ch =='*' || ch =='/'|| ch == '^';	
	}
	
	private int precedence(char ch){
		switch(ch){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
        case '^':
            return 3;
		}	
		return -1;
	}
	
	public String convertor(){
		StringBuilder result =  new StringBuilder();
		Stack<Character> stk = new Stack<>();
		
		for(Character currChar:this.expression.toCharArray()){
			if(Character.isLetterOrDigit(currChar)){
				result.append(currChar);
			}
			else if(currChar == '('){
				stk.push(currChar);
			}
			else if (currChar == ')'){
				while(!stk.isEmpty() && stk.peek()!='('){
					result.append(stk.pop());
				}
				stk.pop();
			}
			else if(isOperator(currChar)){
				while(!stk.isEmpty() && precedence(currChar) <=precedence(stk.peek())){
					result.append(stk.pop());
				}	
				stk.push(currChar);
			}
			
		}
		while(!stk.isEmpty()) {
			result.append(stk.pop());
		}
		return result.toString();
	}
}
