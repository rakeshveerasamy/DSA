class Solution {
    public String countAndSay(int n) {
        CountAndSay cas = new CountAndSay(n);
        return cas.getResult();
    }
}
class CountAndSay{
    private int n;
    private String result;

    CountAndSay(int n){
        this.n = n;
        this.result = "";

        if(isValid()){
            this.result = "1";
            generateSequence();
        }
    }

    private boolean isValid(){
        return this.n>0;
    }

    private void generateSequence(){

        String word = this.result;
        for(int i=1;i<this.n;i++){
            word = getTerm(word);
        }

        this.result=word;
    }

    private String getTerm(String word){
        int len=word.length();
        StringBuilder res = new StringBuilder();
        int i = 0;

        while(i<len){
            int count =1;
            while(i+1<len && word.charAt(i) == word.charAt(i+1)){
                count++;
                i++;
            }

            res.append(count).append(word.charAt(i));
            i++;
        }
        return res.toString();
    }

    public String getResult(){
        return this.result;
    }
}
