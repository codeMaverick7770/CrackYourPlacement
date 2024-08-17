// Flatenn a Binary Tree to LinkedList
// Approach: Traverse recursively using post order traversal, detach the left subtree and attach it to the right of the root. Now, get the pointer to the last Node of the right Subtree of the node which was earlier the left subtree now attach the earlier right subtree to this node
// Time: O(n) and Space: O(h) --> O(n) in the worst case.
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // Flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);
        
        // Store the right subtree
        TreeNode tempRight = root.right;
        
        // Move the left subtree to the right
        root.right = root.left;
        root.left = null; // Set the left to null as required
        
        // Find the last node of the current right subtree (which was the left subtree)
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        
        // Attach the originally stored right subtree
        current.right = tempRight;
    }
}
