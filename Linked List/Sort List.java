class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head.next==null)return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode leftHead = head;
        ListNode rightHead = slow.next;
        slow. next = null;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode t1 = head1;
        ListNode t2 = head2;
        ListNode ansH = null;
        ListNode ansT = null;
        while(t1!=null && t2!=null){
            if(t1.val>t2.val){
                if(ansH==null){
                    ansH=t2;
                    ansT=t2;
                }else{
                    ansT.next = t2;
                    ansT=t2;
                }
                t2 = t2.next;
            }else{
                if(ansH==null){
                    ansH=t1;
                    ansT=t1;
                }else{
                    ansT.next = t1;
                    ansT=t1;
                }
                t1 = t1.next;
            }
        }
        while(t1!=null){
            ansT.next = t1;
            ansT = t1;
            t1 = t1.next;
        }
        while(t2!=null){
            ansT.next = t2;
            ansT = t2;
            t2 = t2.next;
        }
        return ansH;
    }
}
