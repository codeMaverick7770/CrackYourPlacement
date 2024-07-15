//Chocolate Distribution Problem
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
       int start = 0;
       int end = m-1;
       
       Collections.sort(a);
       
       int min = Integer.MAX_VALUE;
       while(end<a.size()){
           min = Math.min(min,a.get(end)- a.get(start));
           start++;
           end++;
       }
       
       
       return min;
       
    }
}
