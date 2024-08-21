class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y-x);
        int sz = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(sz<k){
                    pq.add(matrix[i][j]);
                    sz++;
                }else{
                    if(matrix[i][j]<pq.peek()){
                        pq.remove();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
}
