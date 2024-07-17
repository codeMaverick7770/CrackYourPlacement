//88. Merge Sorted Array
//Time Complexity: O((m+n)log(m+n)) (Can be optimised to O(m+n)) & Space Complexity : O(1) 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = 0;
        for(int i=m; i<nums1.length; i++) {
            if(pointer<n) {
                nums1[i]=nums2[pointer];
                pointer++;
            }

        }
        Arrays.sort(nums1);
        
    }
}
