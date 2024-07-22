class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==val){
                if(cur==head){
                    while(cur.val==val){
                        cur=cur.next;
                        if(cur==null){
                            return null;
                        }
                        head=cur;
                    }
                }else{
                    cur=cur.next;
                    if(cur==null){
                        prev.next=cur;
                    }
                }
            }else{
                if(prev!=null)prev.next=cur;
                prev=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}
