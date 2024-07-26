class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);
        ListNode temp1 = rev1;
        ListNode temp2 = rev2;
        ListNode ansH = null;
        ListNode ansT = null;
        int carry = 0;
        while(temp1!=null && temp2!=null){
            int value = temp1.val+temp2.val+carry;
            temp1.val = value%10;
            carry = value/10;
            if(ansH==null){
                ansH = temp1;
                ansT = temp1;
            }else{
                ansT.next = temp1;
                ansT = temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1!=null){
            int value = temp1.val+carry;
            temp1.val = value%10;
            carry = value/10;
            ansT.next = temp1;
            ansT = temp1;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            int value = temp2.val+carry;
            temp2.val = value%10;
            carry = value/10;
            ansT.next = temp2;
            ansT = temp2;
            temp2 = temp2.next;
        }
        if(carry==1){
            ansT.next = new ListNode(1);
        }
        return reverse(ansH);
    }
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
