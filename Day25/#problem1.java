// 226. Invert Binary Tree
// Given the root of a binary tree, invert the tree, and return its root.
// Approach : Recursively traverse the tree while inverting the left and right nodes.
// Time: O(n) & Space: O(n), due to the recursion stack
class Solution {
    public TreeNode invertTree(TreeNode root) {
        preOrder(root);
        return root;

    }
    public void preOrder(TreeNode root) {
        if(root==null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        preOrder(root.left);
        preOrder(root.right);
    }
}
