class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;
        while(startRow<=endRow && startCol<=endCol){
            for(int i=startCol; i<=endCol; i++){
                ans.add(matrix[startRow][i]);
            }
            startRow++;
            if(startRow>endRow)break;
            for(int i=startRow; i<=endRow; i++){
                ans.add(matrix[i][endCol]);
            }
            endCol--;
            if(startCol>endCol)break;
            for(int i=endCol; i>=startCol; i--){
                ans.add(matrix[endRow][i]);
            }
            endRow--;
            if(startRow>endRow)break;
            for(int i=endRow; i>=startRow; i--){
                ans.add(matrix[i][startCol]);
            }
            startCol++;
        }
        return ans;
    }
}
