import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findMinimumCost(String str) {
		// Write your code here
    ParenthesisValidator pv = new ParenthesisValidator(str);
    return pv.findMinimumCost();
    }
}
class ParenthesisValidator{
  private static int minCostSoFar;
  private String s;
  ParenthesisValidator(String s){
    this.s = s;
    this.minCostSoFar = Integer.MAX_VALUE;
  }
  public int findMinimumCost(){
    if(this.s.length()%2 == 1) return -1;
     findCostHelper(new StringBuilder(this.s),0,0);
     return this.minCostSoFar;
  }
  private void  findCostHelper(StringBuilder s, int index,int cost){
    if(index == this.s.length()){
      if(isValid(s)){
        this.minCostSoFar = Math.min(this.minCostSoFar,cost);
      }
      return;
    }
    if(s.charAt(index) == '{'){
        findCostHelper(s,index+1,cost);
        s.setCharAt(index, '}');
        findCostHelper(s,index+1,cost+1);
        s.setCharAt(index, '{');
    }
    else {
        findCostHelper(s,index+1,cost);
        s.setCharAt(index, '{');
        findCostHelper(s,index+1,cost+1);
        s.setCharAt(index, '}');
    }

  }
  private boolean isValid(StringBuilder s){
    int cnt = 0;
    int n =s.length();
    for(int i = 0;i<n;i++){
      if(s.charAt(i) == '{') cnt ++;
      else if (s.charAt(i) == '}')
      {
        if(cnt<=0)  return false;
        else cnt--;
      }
    }
    return (cnt ==0);
  }
}
