// Removing a node from nth index from the last node of a singly linked list.
// Approach: Calculate the length of the node, n and find the distance of the node to be deleted with respect to the first node. Reach the pointer just before this node and then delete it.
// Time: O(n) & Space: O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // Calculate the length of the list
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        // Find the (len - n)th node
        ListNode prev = dummyHead;
        for (int i = 0; i < len - n; i++) {
            prev = prev.next;
        }

        // Remove the nth node from the end
        prev.next = prev.next.next;

        // Return the new head
        return dummyHead.next;
    }
}

