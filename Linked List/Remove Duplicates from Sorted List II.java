class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p = null;
        ListNode c = head;
        ListNode n = head.next;
        while(n!=null){
            if(c.val==n.val){
                n = n.next;
            }
            else{
                if(c.next!=n){
                    if(p==null){
                        head = n;
                    }else{
                        p.next = n;
                    }
                }else{
                    p = c;
                }
                c = n;
                n = n.next;
            }
        }
        if(c.next!=n){
            if(p==null){
                head = n;
            }else{
                p.next = n;
            }
        }
        return head;
    }
}
