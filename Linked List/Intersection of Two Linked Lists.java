public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1!=null){
            t1 = t1.next;
            sizeA++;
        }
        while(t2!=null){
            t2 = t2.next;
            sizeB++;
        }
        t1 = headA;
        t2 = headB;
        int n=0;
        if(sizeA>sizeB){
            n=sizeA-sizeB;
            while(n>0){
                t1 = t1.next;
                n--;
            }
        }else if(sizeB>sizeA){
            n=sizeB-sizeA;
            while(n>0){
                t2 = t2.next;
                n--;
            }
        }
        while(t1!=null && t2!=null){
            if(t1==t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }
}
