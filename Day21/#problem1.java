// 86. Partition List
// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.
// Approach: Create two new linked lists and add the nodes having values less than x to the first one and the rest to the second one. Link the tail of the first node to the head of the second
// Time: O(n) & Space: O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        // Create two dummy nodes to start the lists for less than and greater than or equal to x
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                // Insert node into the before list
                before.next = head;
                before = before.next;
            } else {
                // Insert node into the after list
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Ensure the last node of after list points to null
        after.next = null;

        // Connect the before list with the after list
        before.next = afterHead.next;

        // Return the head of the partitioned list
        return beforeHead.next;
    }
}
