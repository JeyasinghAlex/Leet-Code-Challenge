public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList_1(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode first = even;
        ListNode second = odd;

        int i = 0;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            if (i % 2 == 0) {
                first.next = node;
                first = node;
            } else {
                second.next = node;
                second = node;
            }
            head = head.next;
            ++i;
        }
        first.next = odd.next;
        return even.next;
    }
}
