// Permutations in array
// Given two arrays of equal size N and an integer K. The task is to check if after permuting both arrays, we get sum of their corresponding element greater than or equal to k i.e Ai + Bi >= K for all i (from 0 to N-1). Return true if possible, else false.
 //Space Comp: O(n) &  & Time Comp: O(nlogn)
class Solution {
    public boolean isPossible(long a[], long b[], int n, long k) {
        // Sort array a in ascending order
        Arrays.sort(a);
        
        // Sort array b in descending order
        Long[] bLong = Arrays.stream(b).boxed().toArray(Long[]::new);
        Arrays.sort(bLong, Collections.reverseOrder());
        
        // Check if the sum of each pair is at least k
        for (int i = 0; i < n; i++) {
            if (a[i] + bLong[i] < k) {
                return false;
            }
        }
        
        return true;
    }
}
