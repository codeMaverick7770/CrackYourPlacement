//Remove duplicates off a linked list
//Time: O(n) & Space: O(1)
//If adjacent nodes have equal values point the node to the non duplicate node. 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head;

        while (currNode != null && currNode.next != null) {
            if (currNode.val == currNode.next.val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }
        return head;
    }
}
