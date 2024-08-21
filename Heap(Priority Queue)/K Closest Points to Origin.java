class Solution {
    class Info implements Comparable<Info>{
        int x;
        int y;
        int dist;
        Info(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info i2){
            return i2.dist-this.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int sz = 0;
        for(int i=0; i<points.length; i++){
            if(sz<k){
                pq.add(new Info(points[i][0], points[i][1], points[i][0]*points[i][0] + points[i][1]*points[i][1]));
                sz++;
            }else{
                int d = points[i][0]*points[i][0] + points[i][1]*points[i][1];
                if(pq.peek().dist>d){
                    pq.remove();
                    pq.add(new Info(points[i][0], points[i][1], d));
                }
            }
        }
        int[][] ans = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()){
            Info myInfo = pq.remove();
            ans[i][0] = myInfo.x;
            ans[i][1] = myInfo.y;
            i++;
        }
        return ans;
    }
    
}
