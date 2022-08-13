public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        int rem = 0;
        ListNode ans = new ListNode();
        ListNode node = ans;

        while (l1 != null || l2 != null || carry != 0) {

            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int c = a + b + carry;
            rem = c % 10;
            carry = c / 10;
            node.next = new ListNode(rem);
            node = node.next;
        }
        return ans.next;
    }
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {

        int cy = 0;
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while (l1 != null || l2 != null) {

            int a = l1 == null ? 0 : l1.val;
            if (l1 != null)
                l1 = l1.next;

            int b = l2 == null ? 0 : l2.val;
            if (l2 != null)
                l2 = l2.next;

            int sum = a + b + cy;
            cy = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (cy != 0) {
            temp.next = new ListNode(cy);
        }
        return ans.next;
    }
}
