// Reverse Linked List between given indices
// Time : O(n) , n being number of nodes and more specifically right, Space: O(1)
// Approach : Initialize dummy node and move leftPrev to the node just before the 'left' node, Start the reversing process and Reconnect the reversed sublist with the rest of the list

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Step 1: Initialize dummy node and move leftPrev to the node just before the 'left' node
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode leftPrev = dummyHead;

        for (int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
        }

        // Step 2: Start the reversing process
        ListNode curr = leftPrev.next;
        ListNode prev = null;

        for (int i = 0; i <= right - left; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: Reconnect the reversed sublist with the rest of the list
        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummyHead.next;
    }
}

