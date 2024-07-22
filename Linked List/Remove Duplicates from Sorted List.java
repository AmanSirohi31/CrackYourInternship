lass Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode x = head;
        ListNode y = head.next;
        while(y!=null){
            if(x.val==y.val){
                y=y.next;
                if(y==null){
                    x.next=null;
                }
            }else{
                x.next=y;
                x = y;
                y = y.next;
            }
        }
        return head;
    }
}
