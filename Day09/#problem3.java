// Smallest window in a string containing all the characters of another string
// Given two strings S and P. Find the smallest window in the string S consisting of all the characters(including duplicates) of the string P.  Return "-1" in case there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index.
// Time Comp: O(|S| + |P|) & Space Comp: O(|S| + |P|)
class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        if (s == null || p == null || s.length() < p.length()) {
            return "-1";
        }

        // Frequency maps
        HashMap<Character, Integer> pattern_freq = new HashMap<>();
        HashMap<Character, Integer> window_freq = new HashMap<>();

        // Populate pattern_freq with the frequency of each character in P
        for (char c : p.toCharArray()) {
            pattern_freq.put(c, pattern_freq.getOrDefault(c, 0) + 1);
        }

        int required = pattern_freq.size();
        int formed = 0;
        int left = 0, right = 0;
        int[] ans = {-1, 0, 0}; // length of window, left, right

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            window_freq.put(c, window_freq.getOrDefault(c, 0) + 1);

            // Check if the current character added has reached the required count in P
            if (pattern_freq.containsKey(c) && window_freq.get(c).intValue() == pattern_freq.get(c).intValue()) {
                formed++;
            }

            // Contract the window till the point where it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Save the smallest window until now
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove characters from the left of the window
                window_freq.put(c, window_freq.get(c) - 1);
                if (pattern_freq.containsKey(c) && window_freq.get(c).intValue() < pattern_freq.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return ans[0] == -1 ? "-1" : s.substring(ans[1], ans[2] + 1);

        
    }
}
