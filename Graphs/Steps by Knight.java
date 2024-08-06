class Solution
{
    class Info{
        int x;
        int y;
        int steps;
        Info(int x, int y, int steps){
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        boolean[][] vis = new boolean[N+1][N+1];
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(KnightPos[0], KnightPos[1], 0));
        int minSteps = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Info cur = q.remove();
            int i = cur.x;
            int j = cur.y;
            int steps = cur.steps;
            
            if(i==TargetPos[0] && j==TargetPos[1]){
                minSteps = Math.min(minSteps, steps);
                continue;
            }
            else if(!vis[i][j]){
                vis[i][j] = true;
                if(i-1>=1 && j+2<=N && !vis[i-1][j+2])q.add(new Info(i-1, j+2, steps+1));
                if(i-1>=1 && j-2>=1 && !vis[i-1][j-2])q.add(new Info(i-1, j-2, steps+1));
                if(i+1<=N && j+2<=N && !vis[i+1][j+2])q.add(new Info(i+1, j+2, steps+1));
                if(i+1<=N && j-2>=1 && !vis[i+1][j-2])q.add(new Info(i+1, j-2, steps+1));
                
                if(j-1>=1 && i+2<=N && !vis[i+2][j-1])q.add(new Info(i+2, j-1, steps+1));
                if(j-1>=1 && i-2>=1 && !vis[i-2][j-1])q.add(new Info(i-2, j-1, steps+1));
                if(j+1<=N && i+2<=N && !vis[i+2][j+1])q.add(new Info(i+2, j+1, steps+1));
                if(j+1<=N && i-2>=1 && !vis[i-2][j+1])q.add(new Info(i-2, j+1, steps+1));
            }
        }
        return minSteps;
    }
}
