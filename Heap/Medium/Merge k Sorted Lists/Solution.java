/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        MergeKList ml = new MergeKList(lists);
        return ml.getResult();
    }
}


class MergeKList{
        
    private ListNode[] lists; 
    private ListNode res;
        
    MergeKList(ListNode [] lists){
        this.lists = lists;
        this.res = null;
        
        if(isValid()){
            mergeLists();   
        }
    }
    
    private boolean isValid(){
            return this.lists!=null && this.lists.length!=0;
    }
    
    private void mergeLists(){
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((list1,list2)->(list1.val-list2.val));
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for(ListNode list: this.lists){
            if(list!=null){
              minHeap.offer(list);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode min = minHeap.poll();
            temp.next = min;
            temp = temp.next;

            if(min.next!=null){
                minHeap.offer(min.next);
            }
        }
        this.res = dummy.next;
    }

    public ListNode getResult(){
            return this.res;
    }
}
