// 28. Find the Index of the First Occurrence in a String
//Time Comp: O(m*n) & Space Comp: O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0; // Edge case: empty needle

        int m = 0; // Pointer for haystack
        int n = 0; // Pointer for needle
        int start = 0; // Track the start index of the match in haystack

        while (m < haystack.length()) {
            if (haystack.charAt(m) == needle.charAt(n)) {
                m++;
                n++;
                if (n == needle.length()) {
                    return m - n; // Return start index of the match
                }
            } else {
                start++; // Move start index to the next position
                m = start; // Reset m to start
                n = 0; // Reset n to 0
            }
        }
        return -1; // Needle not found
    }
}
