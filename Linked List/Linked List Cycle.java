public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            if(slow==fast){
                return true;
            }
            slow = slow.next;
            if(fast.next!=null){
                fast = fast.next.next;
            }else{
                return false;
            }
        }
        return false;
    }
}
