public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        int len = getLength(head);
        k = k % len;

        if (k == 0) {
            return head;
        }

        ListNode node = head;
        for (int i = 0; i < len - k - 1; ++i) {
            node = node.next;
        }
        ListNode ans = node.next;
        ListNode temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        node.next = null;
        return ans;
    }

    private int getLength(ListNode node) {

        int len = 0;
        while (node != null) {
            ++len;
            node = node.next;
        }
        return len;
    }
}
