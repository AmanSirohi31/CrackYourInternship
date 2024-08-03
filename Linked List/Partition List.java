class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val>=x){
                if(rightHead==null){
                    rightHead = temp;
                    rightTail = temp;
                }else{
                    rightTail.next = temp;
                    rightTail = temp;
                }
            }else{
                if(leftHead==null){
                    leftHead = temp;
                    leftTail = temp;
                }else{
                    leftTail.next = temp;
                    leftTail = temp;
                }
            }
            temp = temp.next;
        }
        if(leftHead==null){
            return rightHead;
        }else if(rightHead==null){
            return leftHead;
        }
        leftTail.next = rightHead;
        rightTail.next = null;
        return head=leftHead;
    }
}
