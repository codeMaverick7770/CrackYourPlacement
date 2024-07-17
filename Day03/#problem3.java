//15. 3Sum
//Time Complexity: O(n^2logn) & Space Complexity: O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        //traverse through the array
        for(int i=0; i<nums.length; i++) {
            //initializing the pointers
            int j = i+1;
            int k = nums.length - 1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0) {
                    //adding distinct triplets
                    s.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                } else if(sum>0) {
                    k--;
                } else{
                    j++;
                }
            }
        }
        //copying to the arraylist
        output.addAll(s);
        return output;
    }
}
