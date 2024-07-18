class Solution{
    Node constructTree(int n, int pre[], char preLN[]){
        int[] idx = new int[1];
        idx[0] = 0;
	    return helper(n, pre, preLN, idx);
    }
    Node helper(int n, int[] pre, char preLN[], int[] idx){
        if(idx[0]>=n){
            return null;
        }
        if(preLN[idx[0]]=='L'){
            return new Node(pre[idx[0]]);
        }
        else{
            Node root = new Node(pre[idx[0]]);
            idx[0]+=1;
            root.left = helper(n, pre, preLN, idx);
            idx[0]+=1;
            root.right = helper(n, pre, preLN, idx);
            return root;
        }
        
    }
}
