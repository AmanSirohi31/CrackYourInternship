class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode x = head;
        ListNode y = head.next;
        while(y!=null){
            if(x.val==y.val){
                while(x.val==y.val){
                    y = y.next;
                    if(y==null){
                        x.next=y;
                        return head;
                    }
                }
                x.next=y;
            }else{
                x = y;
                y = y.next;
            }
        }
        return head;
    }
}
