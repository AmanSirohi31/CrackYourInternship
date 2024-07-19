class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        if(root==null){
            return 0;
        }
        if(root.data>=l && root.data<=h){
            int r1 = getCount(root.left, l, h);
            int r2 = getCount(root.right, l, h);
            return r1+r2+1;
        }else if(root.data<l){
            return getCount(root.right, l, h);
        }else{
            return getCount(root.left, l, h);
        }
    }
}
