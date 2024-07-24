class Solution {
    public Node copyRandomList(Node head) {
        Node temp1 = head;
        Node ansH = null;
        HashMap<Node, Node> map = new HashMap<>();
        while(temp1!=null){
            Node n = new Node(temp1.val);
            if(ansH==null){
                ansH = n;
            }
            map.put(temp1, n);
            temp1 = temp1.next;
        }
        temp1 = head;
        Node t;
        while(temp1!=null){
            t = map.get(temp1);
            t.next = map.get(temp1.next);
            t.random = map.get(temp1.random);
            temp1 = temp1.next;
        }
        return ansH;
    }
}
