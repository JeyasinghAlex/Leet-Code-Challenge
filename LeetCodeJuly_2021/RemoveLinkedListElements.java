public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currNode = head;
        ListNode prev = dummy;

        while (currNode != null) {

            if (currNode.val == val) {
                prev.next = currNode.next;
            } else {
                prev = prev.next;
            }
            currNode = currNode.next;
        }
        return dummy.next;
    }
}
