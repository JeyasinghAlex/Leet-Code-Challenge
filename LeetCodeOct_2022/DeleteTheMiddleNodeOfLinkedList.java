public class DeleteTheMiddleNodeOfLinkedList {

    public ListNode deleteMiddle(ListNode head) {

        ListNode node = new ListNode();
        node.next = head;

        ListNode slow = node;
        ListNode fast = node;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }
}
