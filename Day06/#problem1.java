
// Product array puzzle
// Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i]
//Time Complexity: O(n)
// Space Complexity: O(n)
class Solution { 
    public static long[] productExceptSelf(int nums[], int n) {
        // Edge case for arrays of size 1
        if (n == 1) {
            return new long[] { 1 };
        }

        long[] left = new long[n];
        long[] right = new long[n];
        long[] prod = new long[n];

        // Initialize the first element of left array as 1
        left[0] = 1;
        // Initialize the last element of right array as 1
        right[n - 1] = 1;

        // Construct the left array
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        // Construct the right array
        for (int j = n - 2; j >= 0; j--) {
            right[j] = nums[j + 1] * right[j + 1];
        }

        // Construct the product array
        for (int i = 0; i < n; i++) {
            prod[i] = left[i] * right[i];
        }

        return prod;
    }
}
