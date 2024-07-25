class Solution {
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=slow.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp1=head;
        ListNode temp2=reverse(slow.next);
        slow.next=null;
        while(temp2!=null){
            ListNode n1=temp1.next;
            ListNode n2=temp2.next;
            temp1.next=temp2;
            temp2.next=n1;

            temp1=n1;
            temp2=n2;
        }
    }
}
