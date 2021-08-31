public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode temp = head;
        ListNode node = head;
        while (node != null) {
            ++len;
            node = node.next;
        }

        int mid = len - n;
        if (len == 1 && n == 0) {
            return head;
        }
        if (len == 1 && n > 0 || mid  == 0) {
            return head.next;
        }

        ListNode prev = head;
        int i = 0;
        while (temp != null && i < mid) {
            ++i;
            prev = temp;
            temp = temp.next;
        }
        if (prev != null && temp != null)
            prev.next = temp.next;
        return head;
    }
}
