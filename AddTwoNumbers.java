public class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        ListNode lastNode = null;
        int remainder = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int sum = (l1.val + l2.val + remainder);
                ListNode newNode = new ListNode(sum % 10);

                if (firstNode == null) {
                    firstNode = newNode;
                    lastNode = firstNode;
                } else {
                    lastNode.next = newNode;
                    lastNode = newNode;
                }

                remainder = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int sum = l1.val + remainder;
                ListNode newNode = new ListNode(sum % 10);

                if (firstNode == null) {
                    firstNode = newNode;
                    lastNode = firstNode;
                } else {
                    lastNode.next = newNode;
                    lastNode = newNode;
                }

                remainder = sum / 10;
                l1 = l1.next;
            } else {
                int sum = l2.val + remainder;
                ListNode newNode = new ListNode(sum % 10);

                if (firstNode == null) {
                    firstNode = newNode;
                    lastNode = firstNode;
                } else {
                    lastNode.next = newNode;
                    lastNode = newNode;
                }

                remainder = sum / 10;
                l2 = l2.next;
            }
        }

        if (remainder != 0) {
            lastNode.next = new ListNode(remainder);
        }
        
        return firstNode;
    }

}