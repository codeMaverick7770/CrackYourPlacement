// ReOrder List
// Approach: Get the pointer to the middle node, and start reversing the subsequent nodes from the middle to have to different linked lists (the first half, and the second reversed half from the middle)
// now merge the two lists to get the desired order
// Time : O(n) & Space: O(1)

 class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null, curr = slow, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Step 3: Merge the two halves
        ListNode first = head, second = prev;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
