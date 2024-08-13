class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        int left = 0;
        int right = m-1;
        int min = Integer.MAX_VALUE;
        Collections.sort(a);
        while(right<a.size()){
            min = Math.min(min, a.get(right)-a.get(left));
            left++;
            right++;
        }
        return min;
    }
}
