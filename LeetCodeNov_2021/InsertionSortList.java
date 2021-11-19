public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode helper = new ListNode(0);
        ListNode prev = helper;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;
            prev = helper;
            curr = next;
        }
        return helper.next;
    }
}
