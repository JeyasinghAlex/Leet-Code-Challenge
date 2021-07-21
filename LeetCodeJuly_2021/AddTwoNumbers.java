public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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
