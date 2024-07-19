// 462. Minimum Moves to Equal Array Elements II
// Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
// In one move, you can increment or decrement an element of the array by 1.
// Test cases are designed so that the answer will fit in a 32-bit integer.
//Time : O(nlogn) & Space: O(1)
class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length <= 1) {
            return 0; // If there's one or no element, no moves are needed.
        }
        Arrays.sort(nums); // Sort the array to find the median.
        int median = nums[nums.length / 2]; // Median for the sorted array.
        int minMoves = 0;
        
        // Calculate the total number of moves required to make all elements equal to the median.
        for (int i = 0; i < nums.length; i++) {
            minMoves += Math.abs(nums[i] - median);
        }
        
        return minMoves;
    }
}

 
