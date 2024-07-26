class Solution {
    public ListNode reverse(ListNode n1, ListNode n2){
        if(n1==n2){
            return n2;
        }
        ListNode p = reverse(n1.next, n2);
        n1.next.next = n1;
        n1.next = null;
        return p;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        int count=0;
        ListNode ansH = null;
        ListNode ansT = null;
        while(temp2!=null){
            if(count==k-1){
                count=0;
                ListNode nextNode = temp2.next;
                ListNode n = reverse(temp1, temp2);
                if(ansH==null){
                    ansH = n;
                    ansT = temp1;
                }else{
                    ansT.next = n;
                    ansT = temp1;
                }
                temp1 = nextNode;
                temp2 = nextNode;
            }else{
                temp2 = temp2.next;
                count++;
            }
        }
        if(ansH==null){
            return head;
        }
        
        ansT.next = temp1;
        return ansH;
    }
}
