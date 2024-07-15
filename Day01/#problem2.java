//75. Sort Colors

import java.util.*;
class Solution {
    public void sortColors(int[] nums) {
        int length=0;
        for(int i=0; i<nums.length; i++) {
            length=Math.max(length,nums[i]);
        }
        int[] count = new int[length+1];
        for(int i=0; i<nums.length; i++) {
            count[nums[i]]++;
        }
        int index=0;
        for(int i=0; i<count.length; i++) {
            while(count[i]>0) {
                nums[index]=i;
                index++;
                count[i]--; 
            }
            
        }        

        
    }
}
