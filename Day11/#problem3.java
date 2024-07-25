// Minimum Swaps to Sort
// Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.
// Time: O(nlogn) & Space: O(n)


class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int[] nums) {
        int n = nums.length;
        // Create a pair array where each pair contains the element and its index
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        
        // Sort the pair array based on the element values
        Arrays.sort(arr, Comparator.comparingInt(p -> p.value));
        
        // Visited array to mark visited elements
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        int swaps = 0;
        
        // Traverse the array elements
        for (int i = 0; i < n; i++) {
            // If the element is already visited or is already in the correct position
            if (visited[i] || arr[i].index == i) {
                continue;
            }
            
            // Initialize the cycle size
            int cycleSize = 0;
            int j = i;
            
            // Find the cycle size
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j].index;
                cycleSize++;
            }
            
            // If cycle size is greater than 0, then we need (cycleSize - 1) swaps
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
    
    // Pair class to store element and its original index
    class Pair {
        int value;
        int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
