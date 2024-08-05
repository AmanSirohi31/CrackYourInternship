class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        String psf = new String();
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        helper(mat, 0, 0, vis, psf, ans);
        return ans;
    }
    private void helper(int[][] mat, int i, int j, boolean[][] vis, String psf, ArrayList<String> ans){
        if(i<0 || j<0 || i==mat.length || j==mat[0].length || vis[i][j]==true || mat[i][j]==0){
            return;
        }
        vis[i][j] = true;
        if(i==mat.length-1 && j==mat[0].length-1 && mat[i][j]==1){
            ans.add(psf);
            vis[i][j] = false;
            return;
        }
        helper(mat, i-1, j, vis, psf+"U", ans);
        helper(mat, i+1, j, vis, psf+"D", ans);
        helper(mat, i, j-1, vis, psf+"L", ans);
        helper(mat, i, j+1, vis, psf+"R", ans);
        vis[i][j] = false;
    }
}
