class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        if(root==null || root.next==null)return root;
        Node mergedHead = flatten(root.next);
        Node myMerged = merge2Lists(root, mergedHead);
        return myMerged;
    }
    
    Node merge2Lists(Node h1, Node h2){
        Node temp1 = h1;
        Node temp2 = h2;
        Node ansH = null;
        Node ansT = null;
        
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                if(ansH==null){
                    ansH = temp1;
                    ansT = temp1;
                }else{
                    ansT.bottom = temp1;
                    ansT = temp1;
                }
                temp1 = temp1.bottom;
            }else{
                if(ansH == null){
                    ansH = temp2;
                    ansT = temp2;
                }else{
                    ansT.bottom = temp2;
                    ansT = temp2;
                }
                temp2 = temp2.bottom;
            }
        }
        if(temp1!=null){
            ansT.bottom = temp1;
        }
        if(temp2!=null){
            ansT.bottom = temp2;
        }
        return ansH;
    }
}
