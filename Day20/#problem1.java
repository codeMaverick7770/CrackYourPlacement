// 445. Add Two Numbers II
// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Time Complexity: 
// 𝑂(max(𝑛1,𝑛2))
// Space Complexity: 
// 𝑂(1)O(1) auxiliary, 𝑂(max(𝑛1,𝑛2))
// O(max(n1,n2)) for the output list.
// Approach: reverse the lists first and then approach is simiar to the two number sum problem solved earlier reverse back the resultant list which would be th required answer
class Solution {
    public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;
    
    while (current != null) {
        next = current.next;  // Store the next node
        current.next = prev;   // Reverse the current node's pointer
        prev = current;        // Move pointers one position ahead
        current = next;
    }
    
    return prev;  // New head of the reversed list
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = reverseList(l1);
        ListNode rev2 = reverseList(l2);
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (rev1 != null || rev2 != null || carry != 0) {
            int digit1 = (rev1 != null) ? rev1.val : 0;
            int digit2 = (rev2 != null) ? rev2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            rev1 = (rev1 != null) ? rev1.next : null;
            rev2 = (rev2 != null) ? rev2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return reverseList(result);
    }
}
