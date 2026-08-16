class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        String[] mapping = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        generate(res, 0, digits, current, mapping);

        return res;
    }

    private void generate(List<String> res, int index,String digit,  StringBuilder current, String[] mapping){
        if(index == digit.length()){
            res.add(new String(current));
            return;
        }

        String d = mapping[digit.charAt(index)-'0'];

        for(char ch: d.toCharArray()){
            current.append(ch);
            generate(res, index+1, digit, current, mapping);
            current.deleteCharAt(current.length()-1);
        }
    }
}
