class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(existUtil(board, word, i, j, 0, vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean existUtil(char[][] board, String word, int i, int j, int idx, boolean[][] vis){
        if(i<0 || j<0 || i==board.length || j==board[0].length || vis[i][j] || board[i][j]!=word.charAt(idx)){
            return false;
        }
        
        if(idx==word.length()-1)return true;
        
        vis[i][j] = true;
        boolean up = existUtil(board, word, i-1, j, idx+1, vis);
        boolean down = existUtil(board, word, i+1, j, idx+1, vis);
        boolean left = existUtil(board, word, i, j-1, idx+1, vis);
        boolean right = existUtil(board, word, i, j+1, idx+1, vis);
        vis[i][j] = false;
        return up||down||left||right;
    }
}
