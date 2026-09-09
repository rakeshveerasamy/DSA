class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        if(dead.contains("0000") || dead.contains(target)){
            return -1;
        }

        Queue<String> queue  = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");

        int step =0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                String current = queue.poll();

                if(current.equals(target)){
                    return step;
                }

                for(int j=0;j<4;j++){
                    char[] arr = current.toCharArray();
                    int digit = arr[j]-'0';

                    arr[j] = (char)('0' + (digit+1)%10);
                    String next = new String(arr);

                    if(!dead.contains(next) && !visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    } 

                    arr[j] = (char)('0' + (digit+9)%10);
                    next = new String(arr);

                    if(!dead.contains(next) && !visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    } 
                    
                }
            }

            step++;
        }
        return -1;
    }
}
