public class ReverseLinkedList {

    private ListNode headNode = new ListNode(0);
    private ListNode tail = headNode;
    public ListNode reverseList(ListNode head) {

        recursive_1(head);
        return headNode.next;
    }

    private void recursive(ListNode currNode) {

        if (currNode.next == null) {
            headNode = currNode;
            return;
        }
        recursive(currNode.next);
        ListNode nextNode = currNode.next;
        nextNode.next = currNode;
        currNode.next = null;
    }

    private void recursive_1(ListNode head) {
        if (head == null) {
            return;
        }
        recursive(head.next);
        tail.next = new ListNode(head.val);
        tail = tail.next;
    }

}
