// Same Tree
// Approach: Traverse both the trees simultaneously and check if the nodes are equal.
// Time: O(n) & Space: O(n)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        }
        if(p==null || q==null) {
            return false;
        }
        isSameTree(p.left, q.left);
        isSameTree(p.right, q.right);
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
