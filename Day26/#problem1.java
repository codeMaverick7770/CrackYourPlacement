// 101. Symmetric Tree
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
// Approach : Passing the left subtree and rightSubtree and traversing them simultaneously to check if the tree is symmetric (the left node of left tree has to be equal to be the right node of the righttree)
// Time: O(n) && Space: O(h), h being height of the tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode leftRoot, TreeNode rightRoot) {
        if(leftRoot==null && rightRoot==null) {
            return true;
        }
        if(leftRoot==null || rightRoot==null) {
            return false;
        }
        return  leftRoot.val == rightRoot.val && helper(leftRoot.left, rightRoot.right) && helper(leftRoot.right, rightRoot.left);

    }

}
