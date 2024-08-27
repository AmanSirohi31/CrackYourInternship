class Solution {
    public int minPathSum(int[][] grid) {
        int[] row = new int[grid[0].length];

        for(int i=0; i<grid.length; i++){
            int prev = Integer.MAX_VALUE;
            for(int j=0; j<grid[0].length; j++){
                if(i==0 && j==0){
                    row[0] = grid[i][j];
                    prev = grid[i][j];
                }else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i-1>=0){
                        up = row[j];
                    }
                    if(j-1>=0){
                        left = prev;
                    }
                    int sum = grid[i][j] + Math.min(up, left);
                    row[j] = sum;
                    prev = sum;
                }
            }
        }
        return row[grid[0].length-1];
    }
}
