class Solution {
    public Node flatten(Node head) {
        if(head==null)return null;
        Node n = helper(head);
        return head;
    }

    private Node helper(Node head){
        Node last = head;
        Node cur = head;
        while(cur!=null){
            if(cur.child!=null){
                Node childTail = helper(cur.child);
                Node nextNode = cur.next;
                if(nextNode!=null){
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                cur = childTail;
                
            } 
            last = cur;
            cur = cur.next;
        }
        return last; 
    }
}
