public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {

        int len = 0;
        ListNode temp = head;
        ListNode node = head;
        while (node != null) {
            ++len;
            node = node.next;
        }

        int mid = len / 2;
        ListNode prev = null;
        int i = 0;
        while (temp != null && i <= mid) {
            ++i;
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }
}