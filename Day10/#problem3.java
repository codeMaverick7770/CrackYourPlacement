// 424. Longest Repeating Character Replacement
// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int wstart = 0;

        for (int e = 0; e < s.length(); e++) {
            char currentChar = s.charAt(e);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // Find the length of the current window
            int currentWindowLength = e - wstart + 1;
            // Find the maximum frequency of any character in the current window
            int maxFrequency = Collections.max(map.values());

            // If the number of characters to replace exceeds k, shrink the window
            if (currentWindowLength - maxFrequency > k) {
                char startChar = s.charAt(wstart);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                wstart++;
            }

            // Update the maximum length found
            max = Math.max(max, e - wstart + 1);
        }

        return max;
    }
}
