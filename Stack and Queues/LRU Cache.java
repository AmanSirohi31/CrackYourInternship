class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int cap;
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node n = map.get(key);
        remove(n);
        addFront(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            addFront(n);
            n.val = value;
        }else{
            if(cap==map.size()){
                Node lastNode = removeLast();
                map.remove(lastNode.key);
            }
            Node n = new Node(key, value);
            addFront(n);
            map.put(key, n);

        }
    }

    private void remove(Node n){
        Node ahead = n.next;
        Node previous = n.prev;
        ahead.prev = previous;
        previous.next = ahead;
    }

    public Node removeLast(){
        Node prevNode = tail.prev;
        Node prev2Node = prevNode.prev;
        prev2Node.next = tail;
        tail.prev = prev2Node;
        return prevNode;
    }

    private void addFront(Node n){
        Node nextNode = head.next;
        head.next = n;
        n.prev = head;
        n.next = nextNode;
        nextNode.prev = n;
    }
}
