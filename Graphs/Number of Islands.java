class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    helper(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }
    private void helper(char[][] grid, int i, int j, boolean[][] vis){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || vis[i][j]==true || grid[i][j]=='0'){
            return;
        }
        vis[i][j]=true;
        helper(grid, i-1, j, vis);
        helper(grid, i+1, j, vis);
        helper(grid, i, j-1, vis);
        helper(grid, i, j+1, vis);
    }
}
