class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode slow = null;
       ListNode fast = head;
       int k=n;
       while(k-1>0){
        fast = fast.next;
        k--;
       } 
       while(fast!=null && fast.next!=null){
        if(slow==null){
            slow = head;
        }else{
            slow = slow.next;
        }
        
        fast = fast.next;
       }
       if(slow==null){
        return head.next;
       }
       slow.next = slow.next.next;
       return head;
    }
