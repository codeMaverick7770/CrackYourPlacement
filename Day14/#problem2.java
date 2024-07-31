// 206. Reverse Linked List
// Given the head of a singly linked list, reverse the list, and return the reversed list.
// time: O(n) & space: O(1)
// approach: Traverse through the list using three pointers, keep swaping the nodes and return the last node 
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;  // If the list is empty or has one node, return the head as is.
        }
        
        ListNode prev = null;  // Initialize the previous node as null.
        ListNode curr = head;  // Start with the current node as the head of the list.
        
        while (curr != null) {  // Traverse the list.
            ListNode nextTemp = curr.next;  // Save the next node.
            curr.next = prev;  // Reverse the current node's pointer.
            prev = curr;  // Move the previous pointer to the current node.
            curr = nextTemp;  // Move to the next node using the saved pointer.
        }
        
        return prev;  // Return the new head of the reversed list.
    }
}

