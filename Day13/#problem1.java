// 21. Merge Two Sorted Lists
// You are given the heads of two sorted linked lists list1 (n) and list2 (m).
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.
// Time Comp: O(n+m) & Space: O(1)Dummy Node: A dummy node is used to simplify edge cases, such as when one of the lists is empty.
// Approach:
// Pointer Movement:
// If curr1's value is less than or equal to curr2's value, append curr1 to the merged list and move curr1 to its next node.
// Otherwise, append curr2 to the merged list and move curr2 to its next node.
// Always move the prev pointer to the newly added node.
// Append Remaining Nodes: After the loop, if any nodes remain in curr1 or curr2, append them directly to the merged list.
// Return the Merged List: The merged list is available from dummy.next.

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                prev.next = curr1;
                curr1 = curr1.next;
            } else {
                prev.next = curr2;
                curr2 = curr2.next;
            }
            prev = prev.next;
        }
        
        // Append the remaining nodes of either list1 or list2
        if (curr1 != null) {
            prev.next = curr1;
        } else if (curr2 != null) {
            prev.next = curr2;
        }
        
        // Return the merged list, which starts from dummy.next
        return dummy.next;
    }
}
 
