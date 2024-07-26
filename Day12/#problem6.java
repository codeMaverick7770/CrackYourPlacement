//Remove all Nodes of a linked list having value val
//Time: O(n) & space: O(1)
//Used three nodes dummy, currNode & prevNode. Dummy points towards head, while curr points head.next.next and prev head.next. We traverse and compare each node with the val and delete if found equal. handling edge cases is crucial
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Use two pointers, prev (starting at dummy) and curr (starting at head)
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move prev to curr
                prev = curr;
            }
            // Move curr to the next node
            curr = curr.next;
        }
        
        // Return the new head, which is dummy.next
        return dummy.next;
    }
}
