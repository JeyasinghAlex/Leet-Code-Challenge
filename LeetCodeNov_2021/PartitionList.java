public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode firstHead = first;
        ListNode secondHead = second;

        while (head != null) {

            ListNode node = new ListNode(head.val);
            if (head.val < x) {
                firstHead.next = node;
                firstHead = node;
            } else {
                secondHead.next = node;
                secondHead = node;
            }
            head = head.next;
        }
        firstHead.next = second.next;
        return first.next;
    }
}
