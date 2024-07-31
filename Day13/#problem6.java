class Solution {
    private String reverse(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap the characters at left and right
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move towards the middle
            left++;
            right--;
        }

        return new String(charArray);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        String list1 = "";
        String list2 = "";
        String s = "";
        ListNode ans = new ListNode(0);
        while (curr1 != null) {
            list1 += String.valueOf(curr1.val);
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            list2 += String.valueOf(curr2.val);
            curr2 = curr2.next;
        }
        String nl1= reverse(list1);
        String nl2= reverse(list2);

        s = String.valueOf(Integer.parseInt(nl1) + Integer.parseInt(nl2));
        ListNode head = new ListNode(Character.getNumericValue(s.charAt(0)));
        ListNode current = head;

        // Create the rest of the nodes
        for (int i = 1; i < s.length(); i++) {
            current.next = new ListNode(Character.getNumericValue(s.charAt(i)));
            current = current.next;
        }

        return head;

    }
}

