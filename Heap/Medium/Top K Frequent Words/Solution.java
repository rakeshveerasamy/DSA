class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String ,Integer> freqCounter = new HashMap<>();
        for(String word:words){
            freqCounter.put(word,freqCounter.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>(
            (a,b)->{
                    if(a.getValue().equals(b.getValue())){
                        return b.getKey().compareTo(a.getKey());
                    }
                    else{
                        return a.getValue()-b.getValue();
                    }
            }
            
        );

        for(Map.Entry<String,Integer> entry: freqCounter.entrySet()){
            heap.offer(entry);
            if(heap.size()>k){
                heap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while(!heap.isEmpty()){
            result.add(heap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}
