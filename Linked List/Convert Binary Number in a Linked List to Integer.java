class Solution {
    public int getDecimalValue(ListNode head) {
        int n = getSize(head)-1;
        int ans = 0;
        ListNode temp = head;
        while(temp!=null){
            ans+=temp.val*(Math.pow(2, n));
            n--;
            temp=temp.next;
        }
        return ans;
    }
    private int getSize(ListNode head){
        if(head==null){
            return 0;
        }
        return getSize(head.next)+1;
    }
}
