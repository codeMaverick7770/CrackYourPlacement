// 116. Populating Next Right Pointers in Each Node
// Approach: Traverse Recursively and Connect the left child of a node to its right child and if a given node is connected already then connect the left subtree with the right one by connecting right child of left tree with left child of the right tree.
// Time: O(n) & O(1) or O(h) if we consider the implicit recursion statck. ie O(logn) since the tree is perfect
class Solution {
    public Node connect(Node root) {
        jointhetree(root);
        return root;
    }
    
    public void jointhetree(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return;
        }
        
        // Connect the left child to the right child
        root.left.next = root.right;
        
        // Connect the right child to the next subtree's left child
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        
        // Recursively connect the left and right subtrees
        jointhetree(root.left);
        jointhetree(root.right);
    }
}
