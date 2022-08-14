public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {


        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode node = head;
        int len = 1;

        while (node.next != null) {
            ++len;
            node = node.next;
        }

        node.next = head;

        k = len - k % len;

        while (k-- > 0) {
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }

    public ListNode rotateRight_1(ListNode head, int k) {


        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        int len = getLength(head);

        k = k % len;

        if (k == 0) {
            return head;
        }

        for (int i = 1; i <= k; ++i) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode tail = fast;
        tail.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public ListNode rotateRight_2(ListNode head, int k) {

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
