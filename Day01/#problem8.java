//1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;
        //Create the map
        for(int i=0; i<n; i++ ) {
            numMap.put(nums[i],i);
        }
        //Checking if the pair exists in the map
        for(int i=0; i<n; i++) {
            int comp = target - nums[i];
            if(numMap.containsKey(comp) && numMap.get(comp) != i) {
                return new int[]{i, numMap.get(comp)};
            }

        }
        return new int[]{};


        
    }
}
