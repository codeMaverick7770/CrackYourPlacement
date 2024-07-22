// //Check if reversing a sub array make the array sorted
// Given an array of n distinct integers. The task is to check whether reversing any one sub-array can make the array sorted or not. If the array is already sorted or can be made sorted by reversing any one subarray, print “Yes“, else print “No“.
//Time Comp: O(nlogn) & Space: O(n)


class Solution {
  
        static boolean checkReverse(int arr[], int n) { 
        // Copying the array.  
        int temp[] = new int[n]; 
        for (int i = 0; i < n; i++) { 
            temp[i] = arr[i]; 
        } 
  
        // Sort the copied array.  
        Arrays.sort(temp); 
  
        // Finding the first mismatch.  
        int front; 
        for (front = 0; front < n; front++) { 
            if (temp[front] != arr[front]) { 
                break; 
            } 
        } 
  
        // Finding the last mismatch.  
        int back; 
        for (back = n - 1; back >= 0; back--) { 
            if (temp[back] != arr[back]) { 
                break; 
            } 
        } 
  
        // If whole array is sorted  
        if (front >= back) { 
            return true; 
        } 
  
        // Checking subarray is decreasing or not.  
        do { 
            front++; 
            if (arr[front - 1] < arr[front]) { 
                return false; 
            } 
        } while (front != back); 
  
        return true; 
    } 
               }
