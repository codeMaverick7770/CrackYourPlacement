// 25. Reverse Nodes in k-Group
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.
// Approach: Converting the list in groups of k by storing node values to an array list. Now reverse these groups and the resultant list is now converted back to a linkedlist
// Time: O(n) & Space: O(n)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Convert the linked list to an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int n = list.size();
        
        // Reverse elements in groups of k
        for (int i = 0; i + k <= n; i += k) { // Note: i + k <= n ensures we only reverse full groups of k
            int left = i;
            int right = i + k - 1;
            
            // Reverse the elements within the group
            while (left < right) {
                int temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
            }
        }
        
        // Convert the ArrayList back to a linked list
        ListNode head1 = new ListNode(list.get(0));
        ListNode current = head1;
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return head1;
    }
}
