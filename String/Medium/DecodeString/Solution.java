class Solution {
    public String decodeString(String s) {
        DecodeString ds = new DecodeString(s);
        return ds.decode();
    }
}
class DecodeString{
		private String str;
		private int len;
			
		DecodeString(String str){
			this.str = str;
			this.len = len;
		}
		
		public String decode() {
			Stack<Integer> countStack = new Stack<>();
			Stack<StringBuilder> wordStack = new Stack<>();
			StringBuilder currString = new StringBuilder();
			int count=0;
			
			for(char ch: this.str.toCharArray()) {
				if(Character.isDigit(ch)) {
					count = (count*10)+(ch-'0');
				}
				else if (ch == '[') {
					countStack.push(count);
					wordStack.push(currString);
					currString = new StringBuilder();
					count = 0;
				}
				else if (ch == ']') {
					StringBuilder temp = currString;
					int repeat = countStack.pop();
					currString = wordStack.pop();
					for(int i =0;i<repeat;i++) {
						currString.append(temp);
					}
				}
				else {
					currString.append(ch);
				}
			}
			return currString.toString();
		}
}
