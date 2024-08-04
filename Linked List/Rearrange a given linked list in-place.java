class Solution {

    // Should rearrange given linked list such that all even
    // positioned Nodes are before odd positioned.
    // Returns nothing
    void rearrangeEvenOdd(Node head) {
        Node oddHead = null;
        Node oddTail = null;
        Node evenTail = null;
        Node evenHead = null;
        Node temp = head;
        int idx = 1;
        while(temp!=null){
            if(idx%2==0){
                if(evenHead==null){
                    evenHead = temp;
                    evenTail = temp;
                }else{
                    evenTail.next = temp;
                    evenTail = temp;
                }
            }else{
                if(oddHead==null){
                    oddHead = temp;
                    oddTail = temp;
                }else{
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }
            temp = temp.next;
            idx++;
        }
        oddTail.next = evenHead;
        head = oddHead;
    }
}
