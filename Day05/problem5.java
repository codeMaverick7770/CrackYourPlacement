// 67. Add Binary
// Given two binary strings a and b, return their sum as a binary string.
// Time Complexity: 
// O(max(m,n))
// Space Complexity: 
// O(max(m,n))

import java.util.ArrayList;

class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        ArrayList<Character> res = new ArrayList<>();
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry) {
            int sum = 0;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            if (carry) {
                sum += 1;
            }

            carry = sum > 1;
            res.add((char) ('0' + (sum % 2)));
        }

        StringBuilder str = new StringBuilder();
        for (int m = res.size() - 1; m >= 0; m--) {
            str.append(res.get(m));
        }
        return str.toString();
    }
}
