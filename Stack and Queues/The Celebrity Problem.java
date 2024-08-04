class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
       int n = mat.length;
       int m = mat[0].length;
       for(int i=0; i<n; i++){
           int j;
           int flag = 1;
           for(j=0; j<m; j++){
               if(mat[i][j]==1){
                   flag=0;
                   break;
               }
           }
           if(flag==1){
               if(checkCeleb(mat, i)){
                   return i;
                }
           }
       }
       return -1;
    }
    private boolean checkCeleb(int mat[][], int i){
        for(int k=0; k<mat.length; k++){
            if(i!=k && mat[k][i]==0){
                return false;
            }
        }
        return true;
    }
}
