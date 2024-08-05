// Merge k sorted lists
// Approach: Traverse all the linked lists one by one and keep adding the elements inside a list. Sort this arraylist and convert it back to linkedlist.
// Time: O(knlog(kn)) and Space: O(kn)  k being the average size of the linked list inside lists array. 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<lists.length; i++) {
            ListNode head = lists[i];
            while(head!=null) {
                list.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(list);
        if(list.isEmpty()) {
            return null;
        }
        ListNode head1 = new ListNode(list.get(0));
        ListNode current = head1;
        for(int i=1; i<list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;

        }
        return head1;
    }
}
