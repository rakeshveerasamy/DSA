public class Test {
	public static void main(String[] args) {
        String [] dict = new String[] {"baa","abcd","abca","cab","cad"};
        AlienDictionary ad = new AlienDictionary(dict);
        System.out.println(ad.getResult());
    }
}

class AlienDictionary{
	private String [] words;
	private Map<Character,Set<Character>> graph;
	private Map<Character,Integer> indegree;
	private String result;

	AlienDictionary(String[] words){
		this.words = words;
		this.graph = new HashMap<>();
		this.indegree = new HashMap<>();
		this.result = "null";
		if(valid()){
			init();
			findOrder();
		}
	}	
	private boolean valid(){
		return this.words !=null && this.words.length !=0;	
	}
	private void init(){
		for(String s: this.words){
			for(char ch: s.toCharArray()){
				this.graph.putIfAbsent(ch,new HashSet<>());
				this.indegree.putIfAbsent(ch,0);
			}
		}	
	}
	private void findOrder(){
			for(int i =0;i<this.words.length-1;i++){
				String str1 =  this.words[i];
				String str2 = this.words[i+1];
				
				if(str1.length() > str2.length() && str1.startsWith(str2)){
					return;
				}
				int len = Math.min(str1.length(),str2.length());
					
				for(int j=0;i<len;i++){
					char firstCh =  str1.charAt(j);
					char secCh = str2.charAt(j);
					
					if(firstCh != secCh){
						this.graph.get(firstCh).add(secCh);
						this.indegree.put(secCh, this.indegree.get(secCh)+1);
						break;
					}
				}
			}
		
			Queue<Character> q = new LinkedList<>();
		
		for(Map.Entry<Character,Integer> entry: this.indegree.entrySet()){
				if(entry.getValue() == 0){
					q.offer(entry.getKey());
				}
		}
		StringBuilder builder =  new StringBuilder();	
	
		while(!q.isEmpty()){
			char ch =  q.poll();
			builder.append(ch);
			for(char  neighbour: this.graph.getOrDefault(ch,new HashSet<>())){
				this.indegree.put(neighbour, this.indegree.get(neighbour)-1);
				
				if(this.indegree.get(neighbour) == 0){
					q.offer(neighbour);
				}
	
			}
		}
			
		if(builder.length() < this.indegree.size()){
			return;
		}
		this.result = builder.toString();
	}
	public String getResult(){
		return this.result;	
	}
}


