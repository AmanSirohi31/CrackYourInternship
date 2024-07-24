class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry=0;
        ListNode ansH = null;
        ListNode ansT = null;
        while(t1!=null && t2!=null){
            int value = t1.val+t2.val+carry;
            t1.val = value%10;
            if(ansH==null){
                ansH = t1;
                ansT = t1;
            }else{
                ansT.next = t1;
                ansT = t1;
            }
            carry = value/10;
            t1 = t1.next;
            t2 = t2.next;
        }
        while(t1!=null){
            int value = t1.val+carry;
            t1.val = value%10;
            carry = value/10;
            ansT.next = t1;
            ansT = t1;
            t1 = t1.next;
        }
        
        while(t2!=null){
            int value = t2.val+carry;
            t2.val = value%10;
            carry = value/10;
            ansT.next = t2;
            ansT = t2;
            t2 = t2.next;
        }
        if(carry!=0){
            ListNode n = new ListNode(carry);
            ansT.next = n;
            ansT = n;
        }
        return ansH;
    }
}
