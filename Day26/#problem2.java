// 938. Range Sum of BST
// Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
// Approach: Make three cases, and traverse accordingly while taking the sum
// Time: O(logn) && Space: O(logn)

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        //Base Case
        if(root==null) {
            return 0;
        }
        // Case 1: low <= high < root
        if(high < root.val) {
            return rangeSumBST(root.left, low, high);
        } 
        // Case 2: root < low < high
        if(low > root.val) {
            return rangeSumBST(root.right, low, high);
        } 
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        
    }
}
 
