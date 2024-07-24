class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode leftPrev = null;
        ListNode rightNext = null;
        int count=1;
        ListNode temp = head;
        while(count<=right+1){
            if(count==left-1){
                leftPrev = temp;
            }
            if(count==left){
                leftNode = temp;
            }
            if(count==right+1){
                rightNext = temp;
            }
            if(count==right){
                rightNode = temp;
            }
            if(temp!=null){
                temp = temp.next;
            }
            count++;
        }
        ListNode rev = reverse(leftNode, rightNode);
        if(leftPrev==null && rightNext==null){
            return rev;
        }
        if(leftPrev!=null){
            leftPrev.next = rev;
        }
        leftNode.next = rightNext;
        if(leftNode==head){
            return rightNode;
        }
        return head;
    }
    public ListNode reverse(ListNode node, ListNode right){
        if(node==right){
            return node;
        }
        ListNode p = reverse(node.next, right);
        node.next.next = node;
        node.next = null;
        return p;
    }
}
