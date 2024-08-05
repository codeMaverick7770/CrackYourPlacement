// Sort List
// Approach: Store all the node values using an arraylist and then sort the list converting it back into a new linked list.
// Time : O(nlogn) & Space: O(n)
// Can be optimised using merge sort in place sorting of the linked list using the divide and conquer technique

class Solution {
    public static ListNode arrayListToLinkedListHead(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return null;  // Return null if the list is empty
        }

        // Create the head node
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;

        // Iterate through the ArrayList and create the linked list
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        
        return head;  // Return the head of the linked list
    }
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null) {
            list.add(curr.val);
            curr= curr.next;
        }
        Collections.sort(list);
        ListNode head1 = arrayListToLinkedListHead(list);
        return head1; 
    }
}
