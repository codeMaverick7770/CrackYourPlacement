// 1290. Convert Binary Number in a Linked List to Integer
// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
// Return the decimal value of the number in the linked list
// The most significant bit is at the head of the linked list.
// Time : O(n) & Space: O(1)
// Traversed the linked list and stored nodes as a string which I eventually converted to decimal
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode currNode = head;
        String str = "";
        while(currNode!=null) {
            str+=String.valueOf(currNode.val);
            currNode = currNode.next;
        }
        return Integer.parseInt(str, 2);
    }
}
