// Diameter of Binary Tree
// Approach: The approach here is to compute the diameter of a binary tree by recursively finding the maximum diameter of the left and right subtrees, and also considering the sum of heights of the left and right subtrees for each node. The diameter is the longest path between any two nodes in the tree.
// Time: O(n^2) & Space : O(n)
import java.util.*;
class Solution {
    private int height(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int d1 = diameterOfBinaryTree(root.left);
        int d2 = diameterOfBinaryTree(root.right);
        int d3 = height(root.left) + height(root.right);
        return Math.max(d3, Math.max(d1,d2));
        
    }
}
