class Solution {
    public Node subLinkedList(Node head1, Node head2) {
       while(head1!=null && head1.data==0){
           head1 = head1.next;
       }
       while(head2!=null && head2.data==0){
           head2 = head2.next;
       }
       if(head1==null && head2==null){
           return new Node(0);
       }else if(head1==null){
           return head2;
       }else if(head2==null){
           return head1;
       }
        Node temp1;
        Node temp2;
       if(greater(head1, head2)==true){
           temp1 = reverse(head1);
           temp2 = reverse(head2);
       }else{
           temp1 = reverse(head2);
           temp2 = reverse(head1);
       }
       
       Node ansH = null;
       Node ansT = null;
       int borrow = 0;
       while(temp1!=null){
           int value = temp1.data-borrow;
           if(temp2!=null)value = value-temp2.data;
           if(value<0){
               value = value+10;
               borrow = 1;
           }else{
               borrow = 0;
           }
           Node newNode = new Node(value);
           if(ansH==null){
               ansH=newNode;
               ansT=newNode;
           }else{
               ansT.next = newNode;
               ansT = newNode;
           }
           temp1 = temp1.next;
           if(temp2!=null)temp2 = temp2.next;
       }
       
       ansH = reverse(ansH);
       while(ansH!=null && ansH.data==0)ansH = ansH.next;
       if(ansH==null)return new Node(0);
       return ansH;
    }
    private Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    private boolean greater(Node head1, Node head2){
        Node t1 = head1;
        Node t2 = head2;
        while(t1!=null && t2!=null){
            t1 = t1.next;
            t2 = t2.next;
        }
        if(t1==null && t2==null){
            t1 = head1;
            t2 = head2;
            while(t1!=null && t2!=null && t1.data==t2.data){
                t1 = t1.next;
                t2 = t2.next;
            }
            if(t1==null && t2==null)return true;
            if(t1.data>t2.data){
                return true;
            }else{
                return false;
            }
            
        }else if(t2==null){
            return true;
        }else{
            return false;
        }
    }
}
