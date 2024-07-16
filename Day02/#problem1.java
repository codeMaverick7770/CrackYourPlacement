//442. Find All Duplicates in an Array
//Time Complexity : O(N)  //Space Complexity: O(N)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  // Get the index corresponding to the value
            
            // If the value at that index is negative, it means the number is a duplicate
            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                // Mark the value at that index as visited by making it negative
                nums[index] = -nums[index];
            }
        }
        return duplicates;
    }
}
