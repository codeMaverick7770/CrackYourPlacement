//Approach: Stored all the node values in a hashmap and then traversing nodes deleting all the nodes that occured more than once in the hashmap
//Time Complexity: O(n) , space: O(n) can be optimised further.
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ListNode curr = head;
        //Storing Node values in the HashMap
        while(curr!=null) {
            map.put(curr.val, map.getOrDefault(curr.val,0)+1);
            curr = curr.next;
        }
        //Handling edge cases
        while(head!=null && map.get(head.val)>1) {
            head = head.next;
        }
        if(head==null) {
            return null;
        }
        //Deleting duplicate nodes
        ListNode current = head;
        while(current.next!=null) {
            if(map.get(current.next.val)>1) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
        
    }
}
// using O(1) space without hashmap: using two pointers only
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // prev points to the last node before the duplicate sequence

        while (head != null) {
            // Check if the current node has a duplicate
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the current value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev node to the node after the last duplicate
                prev.next = head.next;
            } else {
                // Move prev pointer only if no duplicate was found
                prev = prev.next;
            }
            // Move the head pointer forward
            head = head.next;
        }

        // Return the head of the modified list
        return dummy.next;
    }
}

