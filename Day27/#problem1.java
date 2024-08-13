// 108. Convert Sorted Array to Binary Search Treeclass 
// Approach: Just like binary search, making recursive calls passing low and mid to build the left subtrees and mid+1 and high to build the right subtrees
// Time: O(n) & Space: O(logn)
Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        // Find the middle index
        int mid = left + (right - left) / 2;
        
        // Create the root node with the middle value
        TreeNode root = new TreeNode(nums[mid]);
        
        // Recursively build the left and right subtrees
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        
        return root;
    }
}
