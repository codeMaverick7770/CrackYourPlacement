// Maximum depth of a Binary Tree
// Time & Space: O(n) & O(n)
// Approach: Calculate height recursively at each level starting from the leaves and take maximum between leftTree height and right tree height for nodes at each level.
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int rightHeight = maxDepth(root.right);
        int leftHeight = maxDepth(root.left);
        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
        
    }
}
