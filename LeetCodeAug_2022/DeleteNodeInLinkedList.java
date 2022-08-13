public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode_1(ListNode node) {

        ListNode prev = null;
        while (node.next != null) {
            prev = node;
            node.val = node.next.val;
            node = node.next;
        }
        prev.next = null;
    }
}
