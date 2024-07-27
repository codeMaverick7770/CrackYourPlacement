// Multiply two linked lists
// Given elements as nodes of the two singly linked lists. The task is to multiply these two linked lists, say L1 and L2.
// Time: O(m+n) & Space: O(1)
// Approach :
// Traverse each list and store the Node value into a stringbuilder and later on convert it to Long and multiply.

class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        
        Node curr1 = first;
        Node curr2 = second;
        
        while (curr1 != null) {
            str1.append(curr1.val);
            curr1 = curr1.next;
        }
        
        while (curr2 != null) {
            str2.append(curr2.val);
            curr2 = curr2.next;
        }
        
        long num1 = Long.parseLong(str1.toString());
        long num2 = Long.parseLong(str2.toString());
        
        return num1 * num2;
    }
