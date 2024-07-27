class Solution
{
    Node compute(Node head)
    {
        Node r = reverse(head);
        Node cur = r.next;
        Node max = r;
        while(cur!=null){
            if(cur.data<max.data){
                max.next = cur.next;
                cur = cur.next;
            }else{
                max = cur;
                cur = cur.next;
            }
        }
        return reverse(r);
    }
    Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
