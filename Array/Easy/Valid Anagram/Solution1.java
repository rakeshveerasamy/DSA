//using HashMap
//Time Complexity - O(n)
//Space complexity -O(s) - length of the string

class Solution {
    public boolean isAnagram(String s, String t) {
       if((s==null &&t!=null) || (s!=null && t == null) || (s.length()!=t.length())){
           return false;
       }
       if(s==null && t == null){
           return true;
       }
       HashMap<Character,Integer> hashMap =  new HashMap<>();
        for(Character ch: s.toCharArray()) {
            if(hashMap.containsKey(ch)){
                hashMap.replace(ch,hashMap.get(ch)+1);
                continue;
            }
            hashMap.put(ch,1);
        }
        for(Character ch: t.toCharArray()){
            if(hashMap.containsKey(ch)){
                if(hashMap.get(ch) == 1){
                    hashMap.remove(ch);
                }
                else{
                    hashMap.replace(ch,hashMap.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }
        if(!hashMap.isEmpty()){
           return false;
        }
        return true;

    }
}
