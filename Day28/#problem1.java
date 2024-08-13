// Merge Binary Trees
// Approach: Create a new Tree, if nodes overlap then add their sum value to the mergedNode if one of the nodes is null then return the other one if both are null then return
// Time: O(Max(n,m)) & O(n)
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1==null && root2==null) {
            return null;
        }
        if(root1==null) {
            return root2;
        }
        if(root2==null) {
            return root1;
        }

        TreeNode mergedRoot = new TreeNode(root1.val + root2.val);
        mergedRoot.left = mergeTrees(root1.left,root2.left);
        mergedRoot.right = mergeTrees(root1.right,root2.right);
        return mergedRoot;
    }
}
