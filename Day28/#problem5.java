// Lowest common of a Binary Search Tree
// Approach: If p and q exist on different sides of the current node then return the node and if they dont, then shift the pointer towards the side of the tree in which they exist.
// Time: O(
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if((root == p || root == q) || (root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) return root;
            if(root.val>p.val && root.val>q.val){
                root = root.left;
            }else if(root.val<p.val && root.val<q.val){
                root = root.right;
            }
        }
        return root;
    }
}
