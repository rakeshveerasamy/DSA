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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        RemoveNode rn =  new RemoveNode(head,n);
        return rn.removeNthNode();
    }
}
class RemoveNode{
        private ListNode head;
        private int n;
        RemoveNode(ListNode head, int n){
                this.head = head;
                this.n = n;
        }
        public ListNode removeNthNode(){
               ListNode fastPtr = this.head;
                ListNode slowPtr = this.head;
                for(int i = 0;i<this.n;i++){
                    fastPtr = fastPtr.next;
                }
                if(fastPtr == null)return this.head.next;
                while(fastPtr.next!=null){
                        slowPtr =slowPtr.next;
                        fastPtr =fastPtr.next;
                }
                slowPtr.next = slowPtr.next.next;
                return this.head;
        }
       
}
