// Binary Tree Paths
// Approach: Traverse the tree while storing value of each node and adding it to an arraylist when a leaf is reached.
// Time : O(n*h), h -> height of tree & Space: O(n*h)
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) {
            searchBT(root, "", answer);
        }
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", answer);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", answer);
        }
    }
}
