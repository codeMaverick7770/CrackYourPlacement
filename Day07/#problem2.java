// Find Pair Given Difference
// Given an array arr[] of size n and an integer x, return 1 if there exists a pair of elements in the array whose absolute difference is x, otherwise, return -1.
// Time Comp: O(nlogn), Space Comp: O(n)

class Solution {
    // Simplified isEven method
    public boolean isEven(int x) {
        return x % 2 == 0;
    }
  public int findPair(int n, int x, int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        boolean even = isEven(x);
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (even) {
                // For even x, find pairs of even numbers
                if (isEven(num) && seen.contains(num - x)) {
                    return 1;
                }
                if (isEven(num) && seen.contains(num + x)) {
                    return 1;
                }
            } else {
                // For odd x, find pairs of numbers
                if (!isEven(num) || !isEven(num - x) || !isEven(num + x)) {
                    if (seen.contains(num - x)) {
                        return 1;
                    }
                    if (seen.contains(num + x)) {
                        return 1;
                    }
                }
            }
            seen.add(num);
        }

        return -1;
    }
}
