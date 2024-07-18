// //14. Longest Common Prefix

// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Time Comp: O(s) s--> sum of length of string && Space Comp: O(1)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the prefix
        String prefix = strs[0];
        
        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // Find the common prefix between prefix and strs[i]
            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            // Update the prefix
            prefix = prefix.substring(0, j);
            // If the prefix becomes empty
            if (prefix.isEmpty()) {
                return "";
            }
        }
        
        return prefix;
    }
}
