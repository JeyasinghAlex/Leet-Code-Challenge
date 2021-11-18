public class SortList {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        ListNode list = merge(l1, l2);
        return list;
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (left != null && right != null) {

            int a = left != null ? left.val : 0;
            int b = right != null ? right.val : 0;

            if (a <= b) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }
        return node.next;
    }
}
