class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x,y) -> x.val-y.val);
        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null)pq.add(lists[i]);
        }
        ListNode ansH = null;
        ListNode ansT = null;
        while(!pq.isEmpty()){
            ListNode cur = pq.remove();
            if(ansH==null){
                ansH=cur;
                ansT=cur;
            }else{
                ansT.next = cur;
                ansT = cur;
            }
            if(cur.next!=null){
                pq.add(cur.next);
            }
        }
        return ansH;
    }
}
