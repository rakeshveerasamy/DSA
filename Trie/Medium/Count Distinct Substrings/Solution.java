
import java.util.ArrayList;

public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
        Node root = new Node();
        int count = 0;
        int size = s.length();

        for(int i=0;i<size;i++){
            Node temp = root;

            for(int j= i;j<size;j++){
                char ch = s.charAt(j);

                if(!temp.containsKey(ch)){
                    temp.put(ch, new Node());
                    count++;
                }

                temp = temp.get(ch);
            }
        }
        return count+1;

	}
}


class Node{
    Node[] link;

    Node(){
        this.link = new Node[26];
    }

    public boolean containsKey(char ch){
        return this.link[ch-'a']!=null;
    }

    public Node get(char ch){
        return this.link[ch-'a'];
    }

    public void put(char ch, Node node){
        this.link[ch-'a'] = node;
    }
}
