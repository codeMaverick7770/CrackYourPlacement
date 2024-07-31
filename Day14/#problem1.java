// 234. Palindrome Linked List
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
// Time: O(n) & Space : O(n)
// Approach: Used an Arraylist to store the node values of the list and then checking if the array is a pallindrome
// Optimisation: O(n) space can be reduced to O(1) if we use two pointers and reverse the second half of the list in place

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        ArrayList list = new ArrayList<>();
        boolean res = false;
        while(curr!=null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int left = 0;
        int right = list.size()-1;
        int count = 0;
        int n = list.size();
        if(n==1) {
            res = true;
        }
        while(left<=right) {
            if(list.get(left)==list.get(right)) {
                count++;
                if(count==n/2) {
                    res = true;
                }
            } else {
                return false;
            }
            left++;
            right--;

        }
        return res;
        
    }
}


Optimised: 
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode prev = null, curr = slow, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare the first half with the reversed second half
        ListNode firstHalf = head, secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }
}
 
